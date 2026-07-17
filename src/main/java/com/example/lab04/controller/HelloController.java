package com.example.lab04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController — REST Controller ตัวอย่างสำหรับ Lab03
 *
 * TODO: แก้ไขข้อมูลส่วนตัวด้านล่างให้เป็นของคุณ
 *   - NAME    : ชื่อ-สกุล ของนักศึกษา
 *   - ID      : รหัสนักศึกษา
 *   - SECTION : หมายเลขกลุ่ม (Section)
 */

// ── Annotations ──────────────────────────────────────────────────────────────
// @RestController  = @Controller + @ResponseBody
//   บอก Spring ว่า class นี้คือ REST API controller
//   ทุก method จะ return ข้อมูลตรง (ไม่ใช่ view/template)

// @RequestMapping("/api")
//   กำหนด base URL ของ controller ทั้งหมดในไฟล์นี้
//   ตัวอย่าง: http://localhost:8080/api/...
// ─────────────────────────────────────────────────────────────────────────────

@RestController
@RequestMapping("/api")
public class HelloController {

    // ── ข้อมูลนักศึกษา ── แก้ไขตรงนี้ ──────────────────────────────────────
    private static final String NAME    = "Your Name Here";     // TODO: ใส่ชื่อจริง
    private static final String ID      = "xxxx";               // TODO: ใส่รหัสนักศึกษา
    private static final String SECTION = "x";                  // TODO: ใส่เลข Section
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * GET /api/hello
     *
     * @GetMapping("/hello") — รับ HTTP GET request ที่ path /api/hello
     * @return ข้อความต้อนรับพร้อมข้อมูลนักศึกษา
     *
     * ทดสอบ: http://localhost:8080/api/hello
     */
    @GetMapping("/hello")
    public String hello() {
        return String.format(
            "Hello! My name is %s, Student ID: %s, sec: %s",
            NAME, ID, SECTION
        );
    }

    /**
     * GET /api/info
     *
     * @return ข้อมูลโปรเจกต์ในรูปแบบ JSON-like string
     *
     * ทดสอบ: http://localhost:8080/api/info
     */
    @GetMapping("/info")
    public String info() {
        return String.format(
            "Project: Lab03 Spring Boot | Name: %s | ID: %s | Section: %s",
            NAME, ID, SECTION
        );
    }

    /**
     * GET /api/status
     *
     * endpoint ตรวจสอบว่าแอปทำงานอยู่
     * ทดสอบ: http://localhost:8080/api/status
     */
    @GetMapping("/status")
    public String status() {
        return "Server is running OK";
    }
}
