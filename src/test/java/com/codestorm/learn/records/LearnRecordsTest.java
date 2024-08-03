package com.codestorm.learn.records;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class LearnRecordsTest {
	@Test
	void compareRecordsWithClass(){
		PostClass postClass = new PostClass(1L, "Vacation time!!", LocalDateTime.now());
		System.out.println(postClass);

		PostRecord postRecord = new PostRecord(1L, "Vacation time!!", LocalDateTime.now());
		System.out.println(postRecord);


		System.out.println(postRecord.description());
		System.out.println(postRecord.id());
		System.out.println(postRecord.postedDateTime());
	}

	@Test
	void recordsPlus(){

		PostRecordPlus postRecordPlus1 = new PostRecordPlus(1L, "Vacation time!!");
		System.out.println(postRecordPlus1);

		PostRecordPlus postRecordPlus2 = new PostRecordPlus(1L, "Vacation time!!", LocalDateTime.now());
		System.out.println(postRecordPlus2);

	}

	@Test
	void recordsWithFunction(){

		PostRecordWithFunction postRecordWithFunction = new PostRecordWithFunction();
		postRecordWithFunction.doSomeOperation();
	}

	@Test
	void recordsWithInterfaceImplements(){
		RecordPrinter recordPrinter = new RecordPrinter("Recordsssss!!");
		recordPrinter.printValue();
	}
}
