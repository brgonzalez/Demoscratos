package com.itcr.demoscratos;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		RequestController request = new RequestController("brarigoch@gmail.com", "12345678");
		System.out.println(request.getUserByEmail("brarigoch@gmail.com"));
		request.postRing("feralvarado1304@gmail.com", "brgonzalez@ic-itcr.ac.cr", "brgonzalezcr@gmail.com");
		//System.out.println(request.getRing());
		
	} 
}
