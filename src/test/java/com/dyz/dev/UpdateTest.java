package com.dyz.dev;

import com.dyz.dev.model.Admin;
import com.dyz.dev.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateTest extends DevApplicationTests {
    @Autowired
    AdminService adminService;
    @Test
    public void test() {
        Admin admin = new Admin();
        admin.setUsername("yz1");
        admin.setPassword("yz1");
        adminService.save(admin);
        System.out.println(admin);
        admin.setPassword("yzyz1");
        adminService.update(admin);
        System.out.println(admin);
    }
}
