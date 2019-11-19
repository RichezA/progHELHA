$(document).ready(() => {


    $("#selectionTypeBien").on('change', () => {
        $('#selectionTypeBien option[value="00000000-0000-0000-0000-000000000000"]').remove();
    });

    $("#selectionLocalisation").on('change', () => {
        $('#selectionLocalisation option[value="00000000-0000-0000-0000-000000000000"]').remove();
    });
});