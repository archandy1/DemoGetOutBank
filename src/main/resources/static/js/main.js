
const transactType = document.querySelector("#transact-type");
const transferCard = document.querySelector(".transfer-card");
const depositCard = document.querySelector(".deposit-card");
const withdrawCard = document.querySelector(".withdraw-card");

transactType.addEventListener("change", function() {
    switch(transactType.value) {

        case "transfer":
            transferCard.style.display = "block";
            transferCard.nextElementSibling.style.display = "none";
            depositCard.style.display = "none";
            withdrawCard.style.display = "none";
        break;

        case "deposit":
            depositCard.previousElementSibling.style.display = "none";
            depositCard.style.display = "block";
            depositCard.nextElementSibling.style.display = "none";
            withdrawCard.style.display = "none";
        break;

        case "withdraw":
            
            withdrawCard.previousElementSibling.style.display = "none";
            withdrawCard.style.display = "block";
            transferCard.style.display = "none";

        break;
    }
})