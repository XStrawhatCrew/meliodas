/**
 * Created by windluffy on 8/11/2015.
 */
//document ready
$(document).ready(function() {
    initEventStartup();
});

function initEventStartup() {

    // Event hover and mouse leave div support customer START>>
    $("#support-customer-icon").mouseenter(
        function() {
            $("#support-customer").show();
            $(this).hide();
        }
    );

    $("#support-customer").mouseleave(
        function() {
            $("#support-customer-icon").show();
            $(this).hide();
        }
    );
    // Event hover and mouse leave div support customer END<<
}