package com.quo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.quo.dto.AuthorityDto;
import com.quo.entity.Authority;
@Mapper
public interface AuthorityMapper {
	
	@Select("select mid from authority where rid = #{rid}")
	public List<Integer> findListByRoleId(Integer rid);

	@Delete("delete from authority where rid = #{rid}")
	public void deleteByRoleId(Integer rid);

	@Insert("insert into authority values(null,#{rid},#{mid})")
	public boolean addAuthority(Authority authority);

	@Select("select m.perms from menu m left join authority a on m.mid=a.mid where rid=#{rid}")
	public List<String> getPerms(Integer rid);
}
