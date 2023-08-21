# mac

## 文件操作相关

1. 显示隐藏文件: cmd + shift + .
2. 修改文件的默认打开方式：Option + Cmd + i
3. 在Finder中选择文件或是文件夹，然后按下快捷键 command+Option+C

## 电脑设置
1. 锁屏：Ctrl + Cmd + Q

## 常用设置
1. 打开点按 设置 - 触控板 - 轻点来点按
2. 三指拖动和选择 设置 - 辅助功能 - 指针控制 - 触控板选项 - 启用拖移 - 三指拖移

## 关闭微软自动更新
```shell
cd /Library;
cd Application\ Support/;
cd Microsoft/MAU2.0;
sudo rm -rf Microsoft\ AutoUpdate.app;
```