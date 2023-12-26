# <font color=Red>项目主意事项</font>
## 目录
* 1.[导入项目](#导入)
### <span id="导入">1.导入项目</span>
#### 配置项目的SDK路径
该项目的工程**根目录**下需要自己配置local.properties文件（如果没有请在项目根目录创建一个）  
local.properties文件中存放的是项目的SDK路径  

**实例：**  
在local.properties文件中添加以下内容，根据不同设备自行更改  

```
//这是项目的SDK路径
sdk.dir=C\:\\Users\\你的用户名\\AppData\\Local\\Android\\Sdk
```

#### 本项目开发所使用的Android Studio版本信息：  
Android Studio Giraffe | 2022.3.1 Patch 2  
内部版本号 #AI-223.8836.35.2231.10811636，2023年9月15日 构建  
运行时版本: 17.0.6+0-b2043.56-10027231 amd64  
VM: OpenJDK 64-Bit Server VM，JetBrains s.r.o.  

Windows exe 64 1.1GB
```
https://redirector.gvt1.com/edgedl/android/studio/install/2022.3.1.21/android-studio-2022.3.1.21-windows.exe
```
Windows zip 64 1.1GB
```
https://redirector.gvt1.com/edgedl/android/studio/ide-zips/2022.3.1.21/android-studio-2022.3.1.21-windows.zip
```
Mac 64 1.2GB
```
https://redirector.gvt1.com/edgedl/android/studio/install/2022.3.1.21/android-studio-2022.3.1.21-mac.dmg
```
Mac ARM 64 1.2GB
```
https://redirector.gvt1.com/edgedl/android/studio/install/2022.3.1.21/android-studio-2022.3.1.21-mac_arm.dmg
```
Linux 64 1.2GB
```
https://redirector.gvt1.com/edgedl/android/studio/ide-zips/2022.3.1.21/android-studio-2022.3.1.21-linux.tar.gz
```
ChromeOS 933.8MB
```
https://redirector.gvt1.com/edgedl/android/studio/install/2022.3.1.21/android-studio-2022.3.1.21-cros.deb
```

**<font color=red>导入项目后需要自己编辑运行/调试配置</font>**  
否则无法在虚拟机上运行  

项目apk打包请存放在项目根目录下的app/release中