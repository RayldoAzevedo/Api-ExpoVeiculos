    package br.com.azevedo.rayldo.expo_veiculos.service;


    import com.amazonaws. AmazonServiceException;
    import com.amazonaws.services.s3. AmazonS3;
    import com.amazonaws.services.s3.model.PutobjectRequest;
    import org.springframework.stereotype.Service;

    @Service
    public class S3Service{
        private Logger LOG-Loggerfactory.getlogger(S3Service.class);

        private AmazonS3 s3client;

        @value("${s3.bucket}")
        private String bucketName;
        public void uploadFile(String localFilePath) {
            try {
                File file -new File(localFilePath);
                s3client.putObject(new PutObjectRequest(bucketlame, "teste", file));
            } catch (AmazonServiceException e) I
            LOG.info("AmazonServiceException:" + e.getErrorMessage());
            LOG.info(Status code:+e.getErrorCode());
        }
}
