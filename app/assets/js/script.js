$(document).ready(function() {
    $(".seasons").hide();
    $(".li").hover(function(){
        $(this.getElement(".seasons")).show();
    });
});