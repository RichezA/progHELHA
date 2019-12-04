$(document).ready(() => {
    let buildingType;
    let local;
    let chinf;
    let chsup;

    setUpPopup();
    //$('#submitBtn').on('click', () => {
    //    getValues();
    //    $('#buildingListBlock').html('');

    //    var jsonToSend = {
    //        selectionTypeBien: buildingType,
    //        selectionLocalisation: local,
    //        nbrChambreMin: chinf,
    //        nbrChambreMax: chsup
    //    };

    //    console.log(jsonToSend);

    //    $.ajax({
    //        url: "/Home/GetBuildings",
    //        method: "POST",
    //        data: JSON.stringify(jsonToSend),
    //        success: function (result) {
    //            $('#buildingListBlock').html(result);
    //            setUpPopup();
    //        },
    //        contentType: "JSON"
    //    }).fail(function (xhr, textStatus, errorThrown) {
    //        switch(xhr.status) {
    //            case 404:
    //        alert('Not found');
    //        break;
    //            default:
    //            break;
    //    }
    //    });
    //});

    $("#selectionTypeBien").on('change', () => {
        $('#selectionTypeBien option[value="00000000-0000-0000-0000-000000000000"]').remove();
    });

    $("#selectionLocalisation").on('change', () => {
        $('#selectionLocalisation option[value="00000000-0000-0000-0000-000000000000"]').remove();
    });

    function getValues() {
        buildingType = document.getElementById('selectionTypeBien').value;
        local = document.getElementById('selectionLocalisation').value;
        chinf = document.getElementById('nbrChambreMin').value;
        chsup = document.getElementById('nbrChambreMax').value;
        if (chinf === "") chinf = 0;
        if (chsup === "") chsup = 0;
    }

    function setUpPopup() {
        var id = "";
        $("#popup").hide();
        $(".imgPics").on("mousemove", function (event) {
            $("#popup").css('position', 'absolute');
            var currentId = $(this).data('bienid');
            if (currentId === id) {
                $("#popup").offset({ top: event.pageY - 50, left: event.pageX + 20 });
                return;
            }

            id = currentId;
            console.log('posting: ' + id);
            $.ajax({
                type: "POST",
                url: "/Home/GetDetails/",
                data: currentId,
                success: function (msg) {
                    $("#popup").offset({ top: event.pageY - 50, left: event.pageX + 20 }).show();
                    $("#popup").text(msg);
                },
                statusCode: {
                    404: function () {
                        alert("Not found");
                    }
                }
            });
        });
        $(".imgPics").mouseleave(() => {
            $("#popup").hide();
            $("#popup").offset({ top: 0, left: 0 });
            id = "";
        });
    }
  
});