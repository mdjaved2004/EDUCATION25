function downloadCertificate(){
    const certificate = document.querySelector('#certificate');
    const download_pdf = document.querySelector('#download_certificate');

    download_pdf.addEventListener('click', async () => {
        const { jsPDF } = window.jspdf;

        html2canvas(certificate, {
            scale: 5,
            useCORS: true  //Ensures proper rendering of gradients and external images
        }).then(canvas => {
            const imgData = canvas.toDataURL('image/jpeg', 0.9); //High-quality image compression

            const doc = new jsPDF({
                orientation: 'landscape',
                unit: 'mm',
                format: 'a4'
            });

            const imgWidth = 297;  
            const imgHeight = 210;

            doc.addImage(imgData, 'JPEG', 0, 0, imgWidth, imgHeight); // ? Proper positioning
            doc.save('certificate.pdf');  
        });
    });
}