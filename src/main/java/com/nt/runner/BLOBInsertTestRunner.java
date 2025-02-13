package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerService;
import com.nt.service.IJobSeekerServiceImpl;
@Component
public class BLOBInsertTestRunner implements CommandLineRunner {
	
	@Autowired
	private IJobSeekerServiceImpl service;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Js Name::");
		String name=sc.next();
		System.out.println("Enter the Js Addrs::");
		String addrs=sc.next();
		System.out.println("is it  Js indian?::");
		boolean indian=sc.nextBoolean();
		System.out.println("Enter the Js Photo file Path::");
		String photoPath=sc.next();
		System.out.println("Enter the Js resume file Path::");
		String resumePath=sc.next();
		
		//convert the photofile content into byte[] 
		FileInputStream fis=new FileInputStream(photoPath);
		byte[] photoData=new byte[fis.available()];
		photoData=fis.readAllBytes();
		
		//convert the resumefile content into char[] 
		File file=new File(resumePath);
		FileReader fr=new FileReader(resumePath);
		int length=(int)file.length();
		char[] resumeData=new char[length];
		fr.read(resumeData);
		
		//prepare entity class object
		JobSeeker js=new JobSeeker(name,addrs,photoData,resumeData,indian);
		
		try {
			String msg=service.registerJobSeeker(js);
			System.out.println(msg);
		}
		catch(Exception e) {
				e.printStackTrace();
		}
	}

}
