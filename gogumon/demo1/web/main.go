package main

import (
	"context"
	"fmt"
	"github.com/gorilla/mux"
	"net/http"
	"os"
	"os/signal"
	"syscall"
)

func createRouter() *mux.Router {
	r := mux.NewRouter()

	r.HandleFunc("/healthz", func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(http.StatusOK)
		fmt.Fprint(w, "OK")
		fmt.Println("接口路径-->:", r.RequestURI)
	}).Methods(http.MethodGet)

	return r
}

func createServer(port string, handler http.Handler) *http.Server {
	return &http.Server{
		Addr:    ":" + port,
		Handler: handler,
	}
}

func createSignalHandler(server *http.Server) chan os.Signal {
	stop := make(chan os.Signal, 1)
	signal.Notify(stop, syscall.SIGINT, syscall.SIGTERM)

	go func() {
		<-stop
		fmt.Println("\nShutting down the server...")
		if err := server.Shutdown(context.Background()); err != nil {
			fmt.Println("Server shutdown error:", err)
		}
		close(stop)
	}()

	return stop
}

func main() {
	r := createRouter()

	server := createServer("8080", r)

	stop := createSignalHandler(server)

	fmt.Println("Starting the server...")

	if err := server.ListenAndServe(); err != http.ErrServerClosed {
		fmt.Println("Server listen error:", err)
	}

	<-stop
	fmt.Println("Server stopped.")
}
