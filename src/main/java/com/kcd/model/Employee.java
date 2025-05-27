package com.kcd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("employee")
public record Employee(
    @Id String id,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String department,
    String position,
    String salary,
    String hireDate,
    String managerId,
    String officeLocation,
    String employmentStatus,
    String performanceRating,
    String lastPromotionDate,
    String workEmail,
    String workPhoneNumber,
    String emergencyContactName,
    String emergencyContactPhoneNumber,
    String emergencyContactRelationship,
    String dateOfBirth) {

    }

