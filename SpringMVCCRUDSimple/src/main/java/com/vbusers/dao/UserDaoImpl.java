package com.vbusers.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vbusers.entity.VbUser;  
  
@Repository
public class UserDaoImpl implements UserDao {  
	
	@Autowired
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public boolean isValidUser(String username, String password) {
		int result = template.queryForObject(
			    "select count(*) from vbuser where usrMailAddr = '" + username + "' and usPassword = '" + password + "'", Integer.class);
		
		return (result > 0) ? true : false;
		
	}
	
	public List<VbUser> getVbUsers() {  
	    return template.query("select * from vbuser where usrMailAddr like 'ateq%' limit 5",new RowMapper<VbUser>(){  
	        public VbUser mapRow(ResultSet rs, int row) throws SQLException {  
	        	VbUser vbUser = new VbUser();  
	        	vbUser.setId(rs.getLong(1));
	            vbUser.setUserName(rs.getString(6));
	            vbUser.setPassword(rs.getString(4));
	            vbUser.setFirstName(rs.getString(19));
	            vbUser.setLastName(rs.getString(18));
	            vbUser.setPhoneNo(rs.getString(10));
	            vbUser.setAccNo(rs.getString(2));
	            return vbUser;  
	        }  
	    });  
	}  
	
	public VbUser getVbUserById(long id) {  
	    String sql="select * from vbuser where id = ? ";  
	    return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<VbUser>(VbUser.class));  
	}
	
	public int update(VbUser vbUser) {  
	    String sql="update vbuser set usrMailAddr='"+vbUser.getUserName()+"', usPassword = '" + vbUser.getPassword() + "', usFirstName = '" + vbUser.getFirstName() + "', usLastName = '" + vbUser.getLastName() + "', usPhoneNo = '" + vbUser.getPhoneNo() + "', usAccount = '" + vbUser.getAccNo() + "' where id = " + vbUser.getId();  
	    return template.update(sql);  
	} 

	public int delete(long id) {  
	    String sql="delete from vbuser where id = ? ";  
	    return template.update(sql, id);  
	}  
	
	public void save(VbUser v) {
		String sql="insert into vbuser(usrMailAddr, usPassword, usFirstName, usLastName, usPhoneNo, usAccount) values('"+v.getUserName()+"', '" + v.getPassword() + "', '" + v.getFirstName() + "', '" + v.getLastName() + "', '" + v.getPhoneNo() + "', '" + v.getAccNo() + "')";  
		template.update(sql);
	}
}  