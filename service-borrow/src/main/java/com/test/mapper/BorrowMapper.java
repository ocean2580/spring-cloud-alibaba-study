package com.test.mapper;


import com.test.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface BorrowMapper {
    @Select("select * from DB_BORROW where uid = #{uid}")
    List<Borrow> getBorrowsByUid(int uid);

    @Select("select * from DB_BORROW where bid = #{bid} and uid = #{uid}")
    Borrow getBorrow(int uid, int bid);

    @Insert("insert into DB_BORROW(uid, bid) values(#{uid},#{bid})")
    int addBorrow(int uid, int bid);
}