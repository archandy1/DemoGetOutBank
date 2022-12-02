package com.new_bank_app.helpers;

public class HTML {
    public static String htmlEmailTemplate(String token, String code) {

        String url = "http://127.0.0.1:8080/verify?token=" + token + "&code=" + code;

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <!-- <link rel='stylesheet' href='css/email.css'> -->\n" +
                "\n" +
                "    <style>\n" +
                "            * {\n" +
                "                box-sizing: border-box;\n" +
                "                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\n" +
                "            }\n" +
                "\n" +
                "            body {\n" +
                "                height: 100vh;\n" +
                "                display: flex;\n" +
                "                align-items: center;\n" +
                "                justify-content: center;\n" +
                "                background-color: aliceblue;\n" +
                "            }\n" +
                "\n" +
                "            .wrapper {\n" +
                "                width: 550px;\n" +
                "                height: auto;\n" +
                "                padding: 15px;\n" +
                "                background-color: white;\n" +
                "                border-radius: 7px;\n" +
                "            }\n" +
                "\n" +
                "            .email-msg-header {\n" +
                "            text-align: center; \n" +
                "            }\n" +
                "\n" +
                "            .wrapper span {\n" +
                "                margin: 15px 0;\n" +
                "                font-size: 28px;\n" +
                "                color: #399155;\n" +
                "            }\n" +
                "\n" +
                "            .welcome-text {\n" +
                "                font-size: 18px;\n" +
                "            }\n" +
                "\n" +
                "            /* button */\n" +
                "\n" +
                "            .verify-account-btn {\n" +
                "                padding: 10px 20px;\n" +
                "                background-color: #399155;\n" +
                "                color: white;\n" +
                "                size: 240px 40px;\n" +
                "                border-radius: 20px;\n" +
                "                font: calibre sans-serif;\n" +
                "                text-decoration: none;\n" +
                "                text-transform: uppercase;\n" +
                "                font-weight: 600;\n" +
                "                display: inline-block;\n" +
                "                justify-content: center;\n" +
                "                align-items: center;\n" +
                "            }\n" +
                "    </style>\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<!-- Wrapper -->\n" +
                "<div class='wrapper'>\n" +
                "    <!-- Email Message Header -->\n" +
                "    <h2 class='email-msg-header'>\n" +
                "        Thank You for choosing \n" +
                "        <br>\n" +
                "        \n" +
                "        <span>Get-Out Bank</span>\n" +
                "    </h2>\n" +
                "    \n" +
                "    <center><p class='welcome-text'>\n" +
                "        Your account has been successfully register. Please Click below to verify your account.\n" +
                "    </p></center>\n" +
                "\n" +
                "    <!-- Verify account button -->\n" +
                "    <center><a href='"+ url +"' class='verify-account-btn'>Verify account</a></center>\n" +
                "    <!-- End of Verify account button -->\n" +
                "    <br>\n" +
                "    <br>\n" +
                "</div>\n" +
                "<!-- End of Wrapper -->\n" +
                "    \n" +
                "</body>\n" +
                "</html>";

                return emailTemplate;
    }
}
