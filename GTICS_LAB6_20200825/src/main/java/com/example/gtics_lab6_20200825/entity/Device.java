package com.example.gtics_lab6_20200825.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device", schema = "lab6gtics1")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID", nullable = false)
    private Integer id;

    @Column(name = "DeviceName")
    private String deviceName;

    @Column(name = "DeviceType")
    private String deviceType;

    @Column(name = "Model")
    private String model;

    @Column(name = "SerialNumber")
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site siteID;

}