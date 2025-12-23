package com.vishnu.resumeGen.controller;


import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.repository.UserRepo;
import com.vishnu.resumeGen.service.PdfGenerationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resume")
public class DownloadPdfController {

    private PdfGenerationService pdfGenerationService;
    private UserRepo userRepo;

    public DownloadPdfController(PdfGenerationService pdfGenerationService, UserRepo userRepo) {
        this.pdfGenerationService = pdfGenerationService;
        this.userRepo = userRepo;
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadPdf(@RequestParam String mail) throws Exception{


        UserDetails user = userRepo.findByUserMail(mail);
        byte[] pdf = pdfGenerationService.generateResumePdf(user);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename= " +user.getFullName()+ ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
