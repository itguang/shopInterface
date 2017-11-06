/**
 * 获得base64
 * @param {Object} obj
 * @param {Number} [obj.width] 图片需要压缩的宽度，高度会跟随调整
 * @param {Number} [obj.quality=0.8] 压缩质量，不压缩为1
 * @param {Function} [obj.before(this, blob, file)] 处理前函数,this指向的是input:file
 * @param {Function} obj.success(obj) 处理后函数
 * @example
 *
 */
$.fn.localResizeIMG = function (obj) {
    var fangxiang;
    this.on('change', function () {
        var file = this.files[0];
        var URL = URL || webkitURL;
        var blob = URL.createObjectURL(file);
        var fr = new FileReader;

        fr.onloadend = function() {
            var exif = EXIF.readFromBinaryFile(new BinaryFile(this.result));

            //window.fangxiang=exif['Orientation'];

            //document.getElementById("upload_image").setAttribute("data-fx",window.fangxiang);

            fangxiang=exif['Orientation'] ? exif['Orientation'] : 1;

        };

        fr.readAsBinaryString(file);


        // 执行前函数
        if($.isFunction(obj.before)) { obj.before(this, blob, file) };

        _create(blob, file);
        this.value = '';   // 清空临时数据
    });

    /**
     * 生成base64
     * @param blob 通过file获得的二进制
     */
    function _create(blob) {
        var img = new Image();
        img.src = blob;

        img.onload = function () {
            var that = this;

            //生成比例
            var w = that.width,
                h = that.height,
                scale = w / h;
            w = obj.width || w;
            h = w / scale;


            var degree=0;

            //生成canvas
            var canvas = document.createElement('canvas');
            canvas.width=w;
            canvas.height=h;
            var ctx = canvas.getContext('2d');

            switch(fangxiang) {
                case 1 :
                    ctx.rotate(0 * Math.PI / 180);
                    ctx.drawImage(that, 0, 0,w,h);
                    break;
                case 6 :
                    canvas.width=h;
                    canvas.height=w;
                    ctx.rotate(90 * Math.PI / 180);
                    ctx.drawImage(that, 0, -h,w,h);
                    var z=w;
                    w=h;
                    h=z;
                    break;
                case 3 :
                    ctx.rotate(180 * Math.PI / 180);
                    ctx.drawImage(that, -w, -h,w,h);
                    break;
                case 8 :
                    canvas.width=h;
                    canvas.height=w;

                    ctx.rotate(270 * Math.PI / 180);
                    ctx.drawImage(that, -w, 0,w,h);
                    var z=w;
                    w=h;
                    h=z;
                    break;
            };




            /**
             * 生成base64
             * 兼容修复移动设备需要引入mobileBUGFix.js
             */
            var base64 = canvas.toDataURL('image/jpeg', obj.quality || 0.8 );

            // 修复IOS
            if( navigator.userAgent.match(/iphone/i) ) {
                var mpImg = new MegaPixImage(img);
                mpImg.render(canvas, { maxWidth: w, maxHeight: h, quality: obj.quality || 0.8,orientation:fangxiang});
                base64 = canvas.toDataURL('image/jpeg', obj.quality || 0.8 );
            }

            // 修复android
            if( navigator.userAgent.match(/Android/i) ) {
                var encoder = new JPEGEncoder();
                base64 = encoder.encode(ctx.getImageData(0,0,w,h), obj.quality * 100 || 80 );
            }

            // 生成结果
            var result = {
                height : h,
                base64 : base64,
                clearBase64: base64.substr( base64.indexOf(',') + 1 )
            };

            // 执行后函数
            obj.success(result);

        };
    }
};


// 例子
/*
 $('input:file').localResizeIMG({
 width: 100,
 quality: 0.1,
 //before: function (that, blob) {},
 success: function (result) {
 var img = new Image();
 img.src = result.base64;
 $('body').append(img);
 console.log(result);
 }
 });
 */