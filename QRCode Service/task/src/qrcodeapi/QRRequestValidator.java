package qrcodeapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.Map;

public class QRRequestValidator {
    private static final Map<String, MediaType> imageType = Map.of(
            "png", MediaType.IMAGE_PNG,
            "jpeg", MediaType.IMAGE_JPEG,
            "gif", MediaType.IMAGE_GIF
    );

    private static final Map<String, ErrorCorrectionLevel> correctionLevelMap = Map.of(
            "L", ErrorCorrectionLevel.L,
            "M", ErrorCorrectionLevel.M,
            "Q", ErrorCorrectionLevel.Q,
            "H", ErrorCorrectionLevel.H
    );

    public static ErrorResponseDTO validateParameters(QRRequest qrRequest) {

        if (qrRequest.getContents() == null || qrRequest.getContents().isBlank()) {
            return new ErrorResponseDTO("Contents cannot be null or blank", HttpStatus.BAD_REQUEST);
        }

        if (qrRequest.getSize() < 150 || qrRequest.getSize() > 350) {
            return new ErrorResponseDTO("Image size must be between 150 and 350 pixels", HttpStatus.BAD_REQUEST);
        }

        ErrorCorrectionLevel correctionLevel = correctionLevelMap.get(qrRequest.getCorrection());
        qrRequest.setErrorCorrectionLevel(correctionLevel);
        if (correctionLevel == null) {
            return new ErrorResponseDTO("Permitted error correction levels are L, M, Q, H", HttpStatus.BAD_REQUEST);
        }

        MediaType mediaType = imageType.get(qrRequest.getImageFormat());
        qrRequest.setMediaType(mediaType);
        if (mediaType == null) {
            return new ErrorResponseDTO("Only png, jpeg and gif image types are supported", HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
