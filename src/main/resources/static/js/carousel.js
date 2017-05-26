$(function () {
    'use strict';

    // 轮播
    $('.carousel').carousel({
        interval: false // 不自动轮播
    });
    // 不要使用slide.bs.carousel，改为使用slid.bs.carousel，在完成slide transition之后再触发回调
    $('.carousel').on('slid.bs.carousel', function (direction, relatedTarget) {
        var metadata = $('.carousel .active .metadata-hack').val();
        var backgroundColor = $('.carousel .active .baner-background-color-hack').val();
        // console.log(metadata);
        // console.log(backgroundColor);
        $('#banner').css('background-color', backgroundColor);

        var activeId = app.getActiveCarouselId();
        var activeCarousel = app.getActiveCarouselObject(activeId);
        var form = $('.carousel-form');
        app.fillObjectToForm(activeCarousel, form);
    });

    // 文件上传
    var url = '/file/part';
    var uploadButton = $('<button/>').addClass('btn btn-primary').prop('disabled', true)
        .text('正在上传...')
        .on('click', function () {
            var $this = $(this),
                data = $this.data();
            $this.off('click')
                .text('取消')
                .on('click', function () {
                    $this.remove();
                    data.abort();
                });
            data.submit().always(function (data) {
                $this.remove();
                $('#picture-url').val(data.responseText);
            })
        });
    $('#fileupload').fileupload({
        url: url,
        dataType: 'json',
        autoUpload: false,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
        maxFileSize: 99900000, // 90M
        previewMaxWidth: 300,
        previewMaxHeight: 200,
        previewCrop: true
    }).on('fileuploadadd', function (e, data) {
        data.context = $('<div/>').appendTo('#file');
        $.each(data.files, function (index, file) {
            var node = $('<p/>')
                .append($('<span/>').text(file.name));
            if (!index) {
                node
                    .append('<br>')
                    .append(uploadButton.clone(true).data(data));
            }
            node.appendTo(data.context);
        });
    }).on('fileuploadprocessalways', function (e, data) { // 预览待上传图片
        var index = data.index,
            file = data.files[index],
            node = $(data.context.children()[index]);
        if (file.preview) {
            node
                .prepend('<br>')
                .prepend(file.preview); // 预览图片
        }
        if (file.error) {
            node
                .append('<br>')
                .append($('<span class="text-danger"/>').text(file.error));
        }
        if (index + 1 === data.files.length) {
            data.context.find('button')
                .text('Upload')
                .prop('disabled', !!data.files.error);
        }
    }).on('fileuploadprogressall', function (e, data) {
        $('#progress').css('display', 'block');
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#progress .progress-bar').css(
            'width',
            progress + '%'
        );
    }).on('fileuploaddone', function (e, data) {
        if(data.result) {
            $('#picture-url').val(data.result);
        }
    }).on('fileuploadfail', function (e, data) {
        console.log('上传失败', data);
        /*$.each(data.files, function (index) {
            var error = $('<span class="text-danger"/>').text('文件上传失败');
            $(data.context.children()[index])
                .append('<br>')
                .append(error);
        });*/
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');

    // 设置初始背景颜色
    var setInitialBgColor = function () {
        var backgroundColor = $('.carousel .active .baner-background-color-hack').val();
        $('#banner').css('background-color', backgroundColor);
    };

    var app = {
        getActiveCarouselId: function () {
            var carouselId = $('.carousel .carousel-inner .active .carousel-img').data('carouselId');
            // console.log(carouselId);
            return carouselId;
        },
        getActiveCarouselObject: function (activeId) {
            var carousel;
            for(var i = 0; i < app.carouselsData.length; i++) {
                carousel = app.carouselsData[i];
                if(carousel.id == activeId)
                    return carousel;
            }
            return null;
        },
        fillObjectToForm: function (carousel, form) {
            $.each(carousel, function (k, v) {
                if(k !== 'metadata') {
                    var input = form.find('input[name=' + k + ']');
                    if(input) {
                        input.val(v);
                    }
                }else {
                    var input = form.find('input[name=meta-background-color]');
                    if(input)
                        input.val(carousel[k]['background-color']);
                }
            });
        },
        getCarouselObjFromForm: function (form) {
            var inputs = $(form).find('input'),
                obj = {};
            $.each(inputs, function (k, v) {
                var input = $(v);
                var name = input.attr('name'), val = input.val();
                if(!name.startsWith('meta')) {
                    obj[name] = val;
                }else {
                    if(!obj['metadata'])
                        obj['metadata'] = {};
                    var key = name.substr(5);
                    obj['metadata'][key] = val;
                }
            });

            return obj;
        },
        deleteCarousel: function () {
            $.ajax({
                url: '/carousels/' + app.getActiveCarouselId(),
                type: 'DELETE',
                contentType:"application/json; charset=utf-8",
                success: function(result) {
                }
            });
            window.location.reload();
        },
        addCarousel: function () {
            var formDiv = $('.carousel-form');
            var carousel = app.getCarouselObjFromForm(formDiv);
            $.ajax({
                url: '/carousels',
                type: 'POST',
                data: JSON.stringify(carousel),
                contentType:"application/json; charset=utf-8",
                dataType:"json",
                success: function(result) {
                    window.location.reload();
                },
                error: function (err) {
                    console.log(err);
                }
            });
        },
        updateCarousel: function () {
            var formDiv = $('.carousel-form');
            var carousel = app.getCarouselObjFromForm(formDiv);
            carousel['id'] = app.getActiveCarouselId();
            $.ajax({
                url: '/carousels',
                type: 'PUT',
                data: JSON.stringify(carousel),
                contentType : 'application/json',
                dataType:"json",
                success: function(result) {
                    window.location.reload();
                },
                error: function (err) {
                    console.log(err);
                }
            });
        },
        cancelCarousel: function() {
            var form = $('.carousel-form');
            var inputs = $(form).find('input');
            $.each(inputs, function (k, v) {
                $(v).val(null);
            });
        },
        getCarouselsData: function () {
            var result = eval($('#carousels-data').text());
            // console.log(result);
            return result;
        }
    };

    var init = function () {
        setInitialBgColor();
        app.carouselsData = app.getCarouselsData();

        $('.carousel-img').click(function () {
            var activeId = app.getActiveCarouselId();
            var activeCarousel = app.getActiveCarouselObject(activeId);
            var form = $('.carousel-form');
            app.fillObjectToForm(activeCarousel, form);
        });

        $('#add').click(app.addCarousel);
        $('#update').click(app.updateCarousel);
        $('#delete').click(app.deleteCarousel);
        $('#cancel').click(app.cancelCarousel);

    };
    init();
});
