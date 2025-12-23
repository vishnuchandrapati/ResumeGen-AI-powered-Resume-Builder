package com.vishnu.resumeGen.service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.vishnu.resumeGen.model.UserDetails;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGenerationService {

    private final SpringTemplateEngine templateEngine;


    public PdfGenerationService(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generateResumePdf(UserDetails userDetails) throws IOException {

        Context context = new Context();
        context.setVariable("user", userDetails);

        String html = templateEngine.process("resume", context);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(baos);
            builder.run();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Pdf generation failed" + e);
        }
    }
}
