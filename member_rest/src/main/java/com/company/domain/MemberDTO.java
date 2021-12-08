package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class MemberDTO {
	private String userid;
	private String password;
	private String confirm_password;
	private String name;
	private String gender;
	private String email;
	
	
}