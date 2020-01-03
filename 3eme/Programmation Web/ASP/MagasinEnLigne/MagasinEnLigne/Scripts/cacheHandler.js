$(document).ready(() => {

    $.ajax({
        url: "/Home/GetCookieInfo",
        method: "GET",
        success: function () {

        }
    });

    let inputNumbersBoxes;
    let articleCheckbox;
    let items = [];
    $("#saveBTN").on("click", () => {
        inputNumbersBoxes = $('.numbersInput');
        articleCheckbox = $('.checkbox-article');

        articleCheckbox.map((index) => {
            console.log(articleCheckbox[index].value);
            if (articleCheckbox[index].checked) {
                alert(inputNumbersBoxes[index].value);
                // store them
                items.push({
                    id: inputNumbersBoxes[index].dataset.articlenb,
                    qte: inputNumbersBoxes[index].value
                });
            }
        });
        $.cookie('articles-cache', items);
    });
});