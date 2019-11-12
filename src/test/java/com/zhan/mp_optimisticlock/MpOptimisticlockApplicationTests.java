package com.zhan.mp_optimisticlock;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhan.mp_optimisticlock.entity.Account;
import com.zhan.mp_optimisticlock.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpOptimisticlockApplicationTests {

    @Autowired
    AccountMapper accountMapper;
    @Test
    public void contextLoads() {
        Account byId = accountMapper.selectById(11L);
        System.out.println(byId);

        //修改记录
        byId.setDeposit(BigDecimal.valueOf(123456));
//        byId.setVersion(byId.getVersion());  mybatis plus 会在老版本的version + 1 ，所以不需要再手动+1；

        try {
            System.out.println("开始休眠");
            // 可以延迟10000s ,手动去修改数据库这条数据的version 为其他数字 ，最后的结果就是无法更新成功
            Thread.sleep(10000);// Thread.sleep(10000);
            accountMapper.updateById(byId); // // 3.根据ID修改这条数据（mybatis plus 的内层帮我们多加了一个where条件，保证乐观锁的实现） /
            System.out.println("休眠结束");
            System.out.println(byId);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        Account account = new Account();
//        account.setVersion(1);
//        account.setDeposit(BigDecimal.valueOf(500));
//        int insert = accountMapper.insert(account);
//        int id = account.getId();
//
//
//        Account accountUpdte = new Account();
//        accountUpdte.setId(id);
//        accountUpdte.setDeposit(BigDecimal.valueOf(2684));
//        accountUpdte.setVersion(1);
//        Assert.assertEquals("Should update success", 1, accountMapper.updateById(accountUpdte));
//        Assert.assertEquals("Should version = version+1", 1, accountUpdte.getVersion().intValue());
    }

    /**
     * 批量刚更新
     *update(et,ew) et:必须带上version的值才会触发乐观锁
     */
    @Test
    public void testUpdateByEntitySucc(){
        QueryWrapper<Account> ew = new QueryWrapper<>();
        ew.eq("version", 2);
        Integer count = accountMapper.selectCount(ew);

        Account account = new Account();
        account.setDeposit(BigDecimal.valueOf(8888));
        account.setVersion(1);

//        Assert.assertEquals("updated records should be same", java.util.Optional.ofNullable(count), );
        int update = accountMapper.update(account, null);
        System.out.println("更新成功==="+update);

        ew = new QueryWrapper<>();
        ew.eq("version", 1);

        Integer selectCount = accountMapper.selectCount(ew);
        System.out.println("version 1 ===" + selectCount);


        ew.eq("version", 2);

        Integer totalCount = accountMapper.selectCount(ew);
        System.out.println("version2 ====   "+totalCount);

    }
}
