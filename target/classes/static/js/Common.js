var common = {
    alert: function (title, content) {
        $.alert({
            title: title,
            content: content
        });
    },
    alertSuccess: function (title, content) {
        $.alert({
            title: title,
            content: content,
            type: 'blue',
            animation: 'scale',
            draggable: true
        });
    },
    alertError: function (title, content) {
        $.alert({
            title: title,
            icon: 'fa fa-warning',
            type: 'red',
            content: content
        });
    },
    alertSuccessAction: function (title, content, Action) {
        $.alert({
            title: title,
            content: content,
            type: 'blue',
            animation: 'scale',
            draggable: true,
            buttons: {
                ok: function () {
                    if (Action) {
                        Action();
                    }
                }
            }
        });
    },
    alertErrorAction:function(title, content, Action){
        $.alert({
            title: title,
            icon: 'fa fa-warning',
            type: 'red',
            content: content,
            buttons: {
                ok: function () {
                    if (Action) {
                        Action();
                    }
                }
            }
        });
    }

};
