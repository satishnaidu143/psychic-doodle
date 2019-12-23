package com.nt.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationAppConfig;
import com.nt.controller.MainController;
import com.nt.dto.AttractionsDTO;
import com.sun.corba.se.impl.encoding.CodeSetConversion.CTBConverter;

public class AttractionsTest {

	public static void main(String[] args) {
		
		ApplicationContext pCtx=null, cCtx=null;
		MainController mc=null;
		List<AttractionsDTO> listDTO=new ArrayList<AttractionsDTO>();
			
		pCtx=new AnnotationConfigApplicationContext(BusinessAppConfig.class);
		cCtx=new AnnotationConfigApplicationContext(PresentationAppConfig.class);
		((GenericApplicationContext) cCtx).setParent(pCtx);
						
		/*mc=cCtx.getBean("mc", MainController.class);
		try {
			
			listDTO=mc.readAttractionsByState("AndhraPradesh");
			for (AttractionsDTO attractionsDTO : listDTO) {
				
				System.out.println(attractionsDTO.toString());
			}
			
			
		} catch (Exception e) {
			SQLException se=(SQLException)e;
			System.out.println("internal problem");
			se.printStackTrace();
		}*/
	}
}
