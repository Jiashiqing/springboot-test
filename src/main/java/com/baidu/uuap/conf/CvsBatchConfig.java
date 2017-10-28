//package com.baidu.uuap.conf;
//
//import com.baidu.uuap.pojo.Person;
//import com.baidu.uuap.service.processor.CsvBeanValidator;
//import com.baidu.uuap.service.processor.CsvItemProcessor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.validator.Validator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.sql.DataSource;
//
///**
// * 处理具体工作业务  主要包含三个部分:读数据、处理数据、写数据
// */
//@Configuration
//@EnableBatchProcessing // 开启批处理的支持
//public class CvsBatchConfig {
//
//    private static final String PERSON_INSERT = "INSERT INTO Person (name, age,sex) " +
//            "VALUES (:name,:age,:sex)";
//
//
//    // tag::readerwriterprocessor[] 1.读数据
//    @Bean
//    public ItemReader<Person> reader() {
//        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
//        // 加载外部文件数据 文件类型:CSV
//        reader.setResource(new ClassPathResource("sample-data.csv"));
//        // 在此处对cvs文件的数据和领域模型类做对应映射
//        reader.setLineMapper(new DefaultLineMapper<Person>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[]{"name", "age", "sex"});
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                setTargetType(Person.class);
//            }});
//        }});
//        return reader;
//    }
//
//    //2.处理数据
//    @Bean
//    public ItemProcessor<Person, Person> processor() {
//        CsvItemProcessor csvItemProcessor = new CsvItemProcessor();
//        csvItemProcessor.setValidator(csvBeanValidator());
//        return csvItemProcessor;
//    }
//
//    @Bean
//    public Validator<Person> csvBeanValidator() {
//        return new CsvBeanValidator<Person>();
//    }
//
//    //3.写数据
//    @Bean
//    public ItemWriter<Person> writer(DataSource dataSource) {
//        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
//        writer.setSql(PERSON_INSERT);
//        writer.setDataSource(dataSource);
//        return writer;
//    }
//    // end::readerwriterprocessor[]
//
//
//    // tag::jobstep[]
//    @Bean
//    public Job importUserJob(JobBuilderFactory jobs, @Qualifier("step1") Step s1, @Qualifier("csvJobListener") JobExecutionListener listener) {
//        return jobs.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(s1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader,
//                      ItemWriter<Person> writer, ItemProcessor<Person, Person> processor) {
//        return stepBuilderFactory.get("step1")
//                .<Person, Person>chunk(10)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
//    // end::jobstep[]
//
//}