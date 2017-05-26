$(function () {

    var app = {
        // 从form表单中获取对象
        getObjectByForm: function (form) {
            var inputs = $(form).find('input'), obj = {};
            $.each(inputs, function (k, v) {
                var input = $(v);
                var name = input.attr('name'), val = input.val();
                if(input.attr('type') == 'radio') {
                    obj[name] = $(form).find('input[name=' + name + ']:checked').val();
                } else {
                    obj[name] = val;
                }
            });
            return obj;
        },
        // 把对象装载进form表单中
        parseObjectToForm: function (obj, f) {
            var form = $(f);
            var allInputs = form.find('input');
            $.each(allInputs, function (k, v) {
                var me = $(v);
                if(me.attr('type') == 'radio' || me.attr('type') == 'checkbox') {
                    me.removeAttr('checked');
                } else {
                    me.val(null);
                }
            });

            $.each(obj, function (k, v) {
                var inputs = form.find('input[name=' + k + ']');
                if(inputs.length > 0) {
                    if($(inputs[0]).attr('type') == 'radio') {
                        form.find('[name=' + k + '][value=' + v + ']').prop('checked', 'checked');
                    } else if($(inputs[0]).attr('type') == 'checkbox') {

                    } else {
                        inputs.val(v);
                    }
                }
            });
        },
        addItem: function (e) {

        },
        // 修改单个明细
        updateItem: function (e) {
            var floorId = $('.floor').attr('id');
            var item = app.getObjectByForm('#detailForm');
            $.post('/floors/' + floorId + '/item', item).success(function (res) {
                window.location.reload();
            }).error(function (res) {
                console.log(res);
            });
        },
        deleteItem: function (e) {

        },
        // 取消更新
        cancelUpdate: function (e) {
            var obj = {};
            app.parseObjectToForm(obj, '#detailForm');
        },
        /**
         * 上传配置
         * @type
         */
        uploadConfig: {
            type: 'POST',
            add: function(e, data) {
                console.log('add');
                data.url = '/file';
                data.submit();
            },
            submit: function(e, data) {
                console.log(new Date().toLocaleString() + ': ' + 'submit');
            },
            send: function(e, data) {
                console.log(new Date().toLocaleString() + ': ' + 'send');
            },
            done: function(e, data) {
                var path = data.result;
                $('input[name=pictureUrl]').val(path);
                $('.x-picture-preview').show().find('img').attr('src', path);
            }
        },
        init: function () {
            $('.x-btn-add').click(app.addItem);
            $('.x-btn-update').click(app.updateItem);
            $('.x-btn-cancel').click(app.cancelUpdate);
            $('.x-btn-delete').click(app.deleteItem);
            $('.floor-item-mask').click(function (e) {
                var me = $(this);
                var item = me.parent('li');
                var fi = {
                    id: item.attr('id'),
                    hrefUrl: item.children('a').attr('href'),
                    size: item.data('size'),
                    name: item.find('.floor-item-name').text(),
                    body: item.find('.floor-item-body').text(),
                    pictureUrl: item.find('img').attr('src'),
                    orderNumber: item.find('[data-index]').data('index')
                };
                console.log(fi);

                var form = $('#detailForm');
                $('.x-btn-add').hide();
                $('.x-btn-delete').show();
                $('.x-btn-update').show();
                $('.x-btn-cancel').show();

                // 上传按钮
                app.parseObjectToForm(fi, form);
            });

            // 上传附件
            $('.x-upload').fileupload(app.uploadConfig);
        }
    };

    app.init();

});