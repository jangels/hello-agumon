from gooey import Gooey, GooeyParser
import os
import shutil

@Gooey(program_name="文件重命名工具", language='chinese')
def main():
    # 创建解析器
    parser = GooeyParser(description="选择一个文件并给它一个新名字")
    
    # 添加参数
    parser.add_argument('file_path', help="选择要重命名的文件", widget="FileChooser")
    parser.add_argument('new_name', help="输入新的文件名")
    
    # 解析参数
    args = parser.parse_args()
    
    # 处理文件重命名
    file_path = args.file_path
    new_name = args.new_name
    
    # 分离路径和文件名
    directory = os.path.dirname(file_path)
    old_name = os.path.basename(file_path)
    
    # 构建新路径
    new_path = os.path.join(directory, new_name)
    
    # 重命名文件
    try:
        shutil.move(file_path, new_path)
        print(f"文件重命名成功：{old_name} -> {new_name}")
    except Exception as e:
        print(f"重命名失败：{str(e)}")

if __name__ == '__main__':
    main()