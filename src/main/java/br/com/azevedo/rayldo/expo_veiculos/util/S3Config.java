package br.com.azevedo.rayldo.expo_veiculos.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
    
    /**
     * atibutos das chaves de acesso
     * configurados no arquivo applications.properties
     */

    @Value("${aws.access_key_id}")
    private String awsId;

    @Value("${aws.secret_access_key}")
    private String awsKey;

    @Value("${s3.region}")
    private String region;


    /**
     *  METODO DE AUTENTICAÇÃO PARA ACESSO DO SERVIÇO JDK AWS 
     * @return AWS CREDENTIALS
     */
    @Bean
    public AmazonS3 s3Client(){
        

        BasicAWSCredentials awsCred =  new BasicAWSCredentials(awsId, awsKey);
        AmazonS3 s3client =  AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region)).withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
        return s3client;
    }
}
