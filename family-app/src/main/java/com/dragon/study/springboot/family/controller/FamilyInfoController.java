package com.dragon.study.springboot.family.controller;

import com.dragon.study.springboot.family.module.Family;
import com.dragon.study.springboot.family.service.FamilyInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by dragon on 16/7/12.
 */
@RestController
@RequestMapping("/family")
@Slf4j
public class FamilyInfoController {

  @Autowired
  private FamilyInfoService familyInfoService;


  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  @PreAuthorize("hasAnyAuthority('user')")
  public List<Family> queryAllFamilyInfo() {
    return familyInfoService.queryAllFamilyInfo();
  }

  @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  @PreAuthorize("hasAnyAuthority('admin')")
  public List<Family> queryAdminInfo() {
    return familyInfoService.queryAllFamilyInfo();
  }
}
