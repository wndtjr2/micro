package com.wise;

import com.wise.cfg.DatasourcesCfg;
import com.wise.cfg.JpaPersistenceCfg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Import({JpaPersistenceCfg.class, DatasourcesCfg.class})
@EnableScheduling
public class MsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcApplication.class, args);
	}
}
