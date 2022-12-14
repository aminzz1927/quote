package com.quo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.quo.dto.EmpDto;
import com.quo.dto.MenuDto;
import com.quo.entity.Emp;
import com.quo.entity.SystemSettings;

/** 

* @author zhoumin

*/
@Mapper
public interface SystemMapper {

	//获取审核金额和有效期限
	@Select("select * from systemsettings")
	SystemSettings getSystemSettings();

	//更新审核金额和有效期限
	@Update("update systemsettings set amountCheck=#{amountCheck},expiry=#{expiry}")
	boolean updateSystemSettings(SystemSettings systemSettings);

	//获取登录信息及权限
	/*@Select("select e.ename,d.dname,r.rname,a.mid from emp e left join \r\n"
			+ "role r on e.rid=r.rid left join dept d on r.dno=d.dno left join \r\n"
			+ "authority a on e.rid=a.rid where eno=#{eno}")
	MenuDto getMenuDto(int eno);*/

	
	@Select("select * from emp where eno=#{eno} and pwd=#{pwd}")
	Emp ifExists(int eno, String pwd);
	
	
	@Select("select e.ename,d.dname,r.rname from emp e left join role r on e.rid=r.rid "
			+ "left join dept d on r.dno=d.dno where eno=#{eno}")
	EmpDto getEmpDtoByEno(int eno);



}
