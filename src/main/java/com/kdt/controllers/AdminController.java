package com.kdt.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.domain.entities.Visitor;
import com.kdt.dto.VisitorDTO;
import com.kdt.services.VisitorService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private VisitorService vServ;

    @GetMapping("/todayVisitor")
    public ResponseEntity<VisitorDTO> getTodayVisitor() {
    	try {
            VisitorDTO dto = vServ.getTodayVisitor();
            System.out.println(dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            // 예외가 발생한 경우 처리
            e.printStackTrace(); // 또는 로깅하여 예외 정보 기록
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/createVisitor")
    public ResponseEntity<Void> createVisitor() {
        vServ.createVisitor();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/incrementVisitor/{seq}")
    public ResponseEntity<Void> incrementVisitor(@PathVariable Long seq) {
        try {
            vServ.incrementVisitor(seq);
            System.out.println("실행확인");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/dailyVisitors")
    public ResponseEntity<Visitor> getDailyVisitors() {
        LocalDate today = LocalDate.now();
        Visitor dailyVisitors = vServ.getDailyVisitors(today);
        return ResponseEntity.ok(dailyVisitors);
    }

    @GetMapping("/monthlyVisitors")
    public ResponseEntity<List<Visitor>> getMonthlyVisitors() {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);
        List<Visitor> monthlyVisitors = vServ.getMonthlyVisitors(startOfMonth, endOfMonth);
        return ResponseEntity.ok(monthlyVisitors);
    }
}