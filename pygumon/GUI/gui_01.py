
from gooey import Gooey
import argparse


@Gooey(program_name="简单示例")
def main():
    parser = argparse.ArgumentParser()
    args = parser.parse_args()


if __name__ == '__main__':
    main()