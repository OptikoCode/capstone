$(document).ready(function() {

    // Summernote WYSIWYG
    $('.summernote').summernote({
        minHeight: 300,
        styleTags: [
            { title: 'Paragraph', tag: 'p' },
            { title: 'Blockquote', tag: 'blockquote', className: 'blockquote', value: 'blockquote' },
            'h1', 'h2', 'h3', 'h4', 'h5', 'h6'
        ],
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'italic', 'underline']],
            ['mybutton', ['code']],
            ['misc', ['undo', 'redo']],
            ['view', ['codeview', 'help']]
        ],
        buttons: {
            code: function(context) {
                var ui = $.summernote.ui;

                var button = ui.button({
                    contents: 'code',
                    tooltip: 'Code Block',
                    click: function() {
                        context.invoke('editor.formatBlock', 'pre');
                    }
                });

                return button.render();
            }
        }
    });

    // Show video response form
    $('.add-video-response').click(function() {
        $('.video-response-form').slideDown('fast');
    });




    //GSAP

    let t1 = new TimelineMax();

    t1.from(".scircle", 3, {
        delay: 0.1,
        opacity: 0,
        y: 30,
        ease: Expo.easeInOut
    }).from(".circle", 3, {
        delay: 0.1,
        opacity: 0,
        y: 30,
        ease: Expo.easeInOut
    }, "-=4");

    let t2 = new TimelineMax();

    t2.from(".slide-right", 3, {
        delay: 0.1,
        opacity: 0,
        x: -40,
        ease: Expo.easeOut
    }).from(".slide-right", 3, {
        delay: 0.1,
        opacity: 0,
        x: -40,
        ease: Expo.easeOut
    }, "-=5");

});