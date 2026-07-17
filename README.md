# 🌱 Lab04 — Spring Boot REST API

---

## 📋 วิธี Fork โปรเจกต์นี้

1. กดปุ่ม **Fork** มุมบนขวาของหน้า GitHub นี้
2. เลือก account ของคุณ → กด **Create fork**
3. **เปลี่ยนชื่อ repo** ให้เป็น `67XXXXXXXX-X`  
   โดย `67XXXXXXXX` = รหัสนักศึกษา 10 หลัก, `X` = Section  
   ตัวอย่าง: `6701234567-1`
4. Clone repo ที่ fork มาลงเครื่อง:

```bash
git clone https://github.com/<your-username>/67XXXXXXXX-X.git
cd 67XXXXXXXX-X
```

5. แก้ไขข้อมูลส่วนตัวตาม [ขั้นตอนที่ 4](#-ขั้นตอนที่-4--แก้ไขข้อมูลส่วนตัว) ด้านล่าง

---

##  Prerequisites (สิ่งที่ต้องมีก่อน)

| รายการ | เวอร์ชันที่รองรับ | ตรวจสอบ |
|--------|------------------|---------|
| Java JDK | 17 หรือ 21 | `java -version` |
| Apache Maven | 3.9.x ขึ้นไป | `mvn -v` |
| Git | ใดก็ได้ | `git --version` |

> ⚠️ **ถ้ายังไม่มี JDK** → ดาวน์โหลดได้ที่ https://adoptium.net  
> ⚠️ **ถ้ายังไม่มี Maven** → ดาวน์โหลดได้ที่ https://maven.apache.org/download.cgi

---

## 🌐 วิธีสร้างโปรเจกต์ Spring Boot ใหม่ (ถ้าไม่ Fork)

> Spring Boot **ไม่มีการติดตั้งแยก** — สร้างผ่าน IDE หรือ Spring Initializr แล้ว Maven จะดึง dependency มาให้อัตโนมัติ

---

## 🟣 Eclipse — ติดตั้ง Spring Tools และสร้าง Spring Boot Project

> **Spring Tools 4 (ST4)** คือ plugin ล่าสุดสำหรับ Eclipse  
> เวอร์ชันปัจจุบัน: **4.32.x** (Spring Tools 3 หยุดพัฒนาแล้ว อย่าลงผิด)

### ขั้นตอนที่ 1 — ติดตั้ง Spring Tools 4 ผ่าน Eclipse Marketplace

1. เปิด Eclipse → **Help → Eclipse Marketplace**
2. ช่อง Search พิมพ์ `Spring Tools` → กด Enter
3. เลือก **Spring Tools 4 (aka Spring Tool Suite 4)** → กด **Install**
4. ติ๊กถูก features ที่ต้องการ → กด **Confirm**
5. ยอมรับ License → กด **Finish**
6. รอติดตั้ง → Eclipse จะขอ Restart → กด **Restart Now**

> ⚠️ ถ้าหา Marketplace ไม่เจอ ให้ไปที่  
> **Help → Install New Software** → วาง URL นี้:  
> `https://cdn.spring.io/spring-tools/release/update/latest/`  
> แล้วกด Add → ติ๊กเลือก features → กด Next จนเสร็จ

---

### ขั้นตอนที่ 2 — สร้าง Spring Boot Project ใน Eclipse

**1. สร้างโปรเจกต์ใหม่**
- File → New → Other
- พิมพ์ `Spring` → เลือก **Spring Starter Project** → Next

**2. กรอกข้อมูลโปรเจกต์**
- Name: `67XXXXXXXX-X`
- Type: `Maven`
- Packaging: `Jar`
- Java Version: `17`
- Group: `com.example`
- Artifact: `67XXXXXXXX-X`
- กด Next

**3. เพิ่ม Dependencies**
- ช่อง Search พิมพ์ `Spring Web` → ติ๊ก ✓
- พิมพ์ `DevTools` → ติ๊ก **Spring Boot DevTools** ✓
- กด Finish

**4. รอ Eclipse ดาวน์โหลด Dependencies**
- ดูแถบ progress ล่างขวา รอจนหาย (ประมาณ 1-3 นาที)
- โปรเจกต์ปรากฏใน Package Explorer

**5. รันโปรเจกต์**
- คลิกขวาที่โปรเจกต์ → Run As → **Spring Boot App**
- Console แสดง `Tomcat started on port 8080` = พร้อมใช้งาน ✅

---

## 🔵 VS Code — สร้าง Spring Boot Project

> ต้องติดตั้ง Extension ก่อน:
> - **Extension Pack for Java**
> - **Spring Boot Extension Pack**

**1. เปิด Command Palette**
- กด `Ctrl+Shift+P` (Windows) หรือ `Cmd+Shift+P` (Mac)

**2. สร้างโปรเจกต์**
- พิมพ์ `Spring Initializr: Create a Maven Project`
- กด Enter

**3. เลือกค่าทีละขั้น** (VS Code จะถามทีละอย่าง)
- Spring Boot version → เลือก `3.3.x`
- Language → `Java`
- Group Id → `com.example`
- Artifact Id → `67XXXXXXXX-X`
- Packaging → `Jar`
- Java version → `17`

**4. เพิ่ม Dependencies**
- พิมพ์ `Spring Web` → กด Space เพื่อติ๊ก ✓
- พิมพ์ `DevTools` → กด Space เพื่อติ๊ก **Spring Boot DevTools** ✓
- กด Enter เพื่อยืนยัน

**5. เลือก folder ที่จะเซฟโปรเจกต์**
- เลือก folder → กด **Generate into this folder**
- VS Code จะถามให้ Open folder → กด **Open**

**6. รันโปรเจกต์**
```bash
# เปิด Terminal (Ctrl+`)
mvn spring-boot:run
```
- Terminal แสดง `Tomcat started on port 8080` = พร้อมใช้งาน ✅

---

## 🗂️ โครงสร้างโปรเจกต์

```
67XXXXXXXX-X/
├── pom.xml                                         ← config หลักของ Maven/Spring Boot
├── .gitignore
├── README.md
└── src/
    ├── main/
    │   ├── java/com/example/lab03/
    │   │   ├── Lab03Application.java               ← จุดเริ่มต้นแอป (main)
    │   │   └── controller/
    │   │       └── HelloController.java            ← REST Controller ← แก้ตรงนี้
    │   └── resources/
    │       └── application.properties             ← ตั้งค่า port, logging
    └── test/
        └── java/com/example/lab03/
            └── Lab03ApplicationTests.java          ← unit test
```

---

## 🚀 ขั้นตอนที่ 1 — ติดตั้ง JDK

### Windows
1. ไปที่ https://adoptium.net
2. เลือก **JDK 17** (LTS) → กด **Download**
3. รันไฟล์ `.msi` ที่ดาวน์โหลดมา → กด **Next** จนเสร็จ
4. ตรวจสอบ:

```powershell
java -version
# ควรขึ้น: openjdk version "17.x.x" ...
```

5. ตั้งค่า `JAVA_HOME`:
   - เปิด **System Properties** → **Environment Variables**
   - กด **New** ใต้ User variables
   - `Variable name`: `JAVA_HOME`
   - `Variable value`: `C:\Program Files\Eclipse Adoptium\jdk-17.x.x.x-hotspot`
   - กด OK → เปิด PowerShell ใหม่แล้วรัน `java -version` อีกครั้ง

### macOS
```bash
brew install openjdk@17

export JAVA_HOME=$(/usr/libexec/java_home -v17)
export PATH="$JAVA_HOME/bin:$PATH"

source ~/.zshrc
java -version
```

---

## 🔧 ขั้นตอนที่ 2 — ติดตั้ง Apache Maven

### Windows
1. ดาวน์โหลด Binary zip archive จาก https://maven.apache.org/download.cgi
2. แตกไฟล์ไปไว้ที่ `C:\Program Files\Apache\maven\apache-maven-3.9.x`
3. ตั้งค่า Environment Variables:
   - `MAVEN_HOME` = `C:\Program Files\Apache\maven\apache-maven-3.9.x`
   - เพิ่ม `%MAVEN_HOME%\bin` ใน **Path**
4. เปิด PowerShell ใหม่แล้วตรวจสอบ:

```powershell
mvn -v
# ควรขึ้น: Apache Maven 3.9.x ...
```

### macOS / Linux
```bash
# macOS
brew install maven

# Ubuntu / Debian
sudo apt update && sudo apt install maven -y

mvn -v
```

---

## 📦 ขั้นตอนที่ 3 — Clone และเปิดโปรเจกต์

```bash
# 1. Clone repo (ใช้ URL ของ fork คุณเอง)
git clone https://github.com/<your-username>/67XXXXXXXX-X.git

# 2. เข้า folder
cd 67XXXXXXXX-X

# 3. ดาวน์โหลด dependencies (ครั้งแรกอาจใช้เวลา 2-5 นาที)
mvn dependency:resolve
```

---

## ✏️ ขั้นตอนที่ 4 — แก้ไขข้อมูลส่วนตัว

เปิดไฟล์ `src/main/java/com/example/lab03/controller/HelloController.java`

แก้ไข 3 บรรทัดนี้:

```java
private static final String NAME    = "Your Name Here";  // ← ใส่ชื่อ-สกุลจริง
private static final String ID      = "xxxx";            // ← ใส่รหัสนักศึกษา
private static final String SECTION = "x";               // ← ใส่เลข Section
```

**ตัวอย่างหลังแก้แล้ว:**

```java
private static final String NAME    = "สมชาย ใจดี";
private static final String ID      = "6701234567";
private static final String SECTION = "1";
```

---

## ▶️ ขั้นตอนที่ 5 — Build และรันโปรเจกต์

### ผ่าน Command Line

```bash
mvn clean package
mvn spring-boot:run
```

> ✅ **สัญญาณว่ารันสำเร็จ:**
> ```
> Started Lab03Application in 2.345 seconds (JVM running for 2.8)
> Tomcat started on port 8080
> ```

### ผ่าน Eclipse
1. คลิกขวาที่โปรเจกต์ → **Run As** → **Spring Boot App**
2. ดูผลใน Console tab

### ผ่าน VS Code
```bash
# เปิด Terminal ใน VS Code (Ctrl+`)
mvn spring-boot:run
```

---

## 🌐 ขั้นตอนที่ 6 — ทดสอบ API

| URL | ผลลัพธ์ที่คาดหวัง |
|-----|------------------|
| http://localhost:8080/api/hello | `Hello! My name is ..., Student ID: ..., sec: ...` |
| http://localhost:8080/api/info | `Project: Lab03 Spring Boot \| Name: ... \| ID: ...` |
| http://localhost:8080/api/status | `Server is running OK` |

```bash
# หรือทดสอบผ่าน Terminal
curl http://localhost:8080/api/hello
```

---

## 🛑 ขั้นตอนที่ 7 — หยุดแอปพลิเคชัน

```bash
^C   # Ctrl + C
```

---

## 🔄 ขั้นตอนที่ 8 — Commit และ Push ขึ้น GitHub

```bash
git status
git add .
git commit -m "feat: update student info - ID 67XXXXXXXX sec X"
git push origin main
```

> ⚠️ **GitHub มี 2 แบบที่ต้องระวัง:**
> - **Login บนเว็บ github.com** → ใช้ password ปกติได้
> - **git push / git pull ผ่าน Terminal** → ใช้ password ไม่ได้ ต้องใช้ **Personal Access Token** แทน
>
> วิธีสร้าง Token: GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic) → Generate new token → ติ๊ก `repo` → Copy token แล้วใช้แทน password

---

## 🐛 Troubleshooting

| ปัญหา | สาเหตุ | วิธีแก้ |
|-------|--------|---------|
| `JAVA_HOME is not defined` | ยังไม่ตั้งค่า JAVA_HOME | ดู [ขั้นตอนที่ 1](#-ขั้นตอนที่-1--ติดตั้ง-jdk) |
| `mvn: command not found` | Maven ไม่อยู่ใน PATH | ดู [ขั้นตอนที่ 2](#-ขั้นตอนที่-2--ติดตั้ง-apache-maven) |
| Port 8080 already in use | มีแอปอื่นใช้ port อยู่ | แก้ `server.port=9090` ใน `application.properties` |
| `BUILD FAILURE` ตอน compile | Java syntax error | ดูบรรทัดที่ขึ้น `ERROR` ใน console |
| กด Push แล้วขอ login | GitHub ต้องการ token | ใช้ Personal Access Token แทน password |

---

## 📁 สิ่งที่ต้องส่ง

- [ ] Fork repo นี้ และตั้งชื่อ repo เป็น `67XXXXXXXX-X`
- [ ] Push โค้ดพร้อมข้อมูลของตัวเองขึ้น GitHub
- [ ] แสดง commit history อย่างน้อย 2 commits
- [ ] Screenshot Browser ที่เรียก `/api/hello` และ `/api/info`
- [ ] ส่งไฟล์ PDF ชื่อ `Lab04_xxxxSec#.pdf`
