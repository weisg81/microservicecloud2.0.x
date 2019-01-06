package pers.weisg.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import pers.weisg.springcloud.entities.Dept;

@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept get(long id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                dept.setDb_source("no this database in MySQL");
                return dept;
            }

            public List<Dept> list() {
                return null;
            }

            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
