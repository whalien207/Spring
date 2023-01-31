package ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ServiceImpl {
	
	private DAO dao;
	
	@Autowired
	public ServiceImpl (DAO dao) {
		this.dao = dao;
	}

	public String hello() {
		return dao.hello();
	}
}
