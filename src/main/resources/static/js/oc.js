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

});