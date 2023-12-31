package qrcodeapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class Controller {

    @GetMapping("/health")
    public ResponseEntity<String> getApiStatus() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    public ResponseEntity<?> QRCodeController (@RequestParam String contents,
                                               @RequestParam (defaultValue = "250") int size,
                                               @RequestParam (value = "type", defaultValue = "png") String imageFormat,
                                               @RequestParam (defaultValue = "L") String correction) {

        QRRequest qrRequest = new QRRequest(contents, size, imageFormat, correction);


        ErrorResponseDTO parametersValidationErrorResponseDTO = QRRequestValidator.validateParameters(qrRequest);
        if (parametersValidationErrorResponseDTO != null) {
            return ResponseEntity
                    .status(parametersValidationErrorResponseDTO.getHttpStatus())
                    .body(parametersValidationErrorResponseDTO);
        }

        BufferedImage bufferedImage = QRgenerator.generate(qrRequest);

        return ResponseEntity
                .ok()
                .contentType(qrRequest.getMediaType())
                .body(bufferedImage);
    }
}
