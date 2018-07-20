var merge = require('webpack-merge');
var core = require('./webpack-core.config.js');
var path = require("path");
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = merge(core, {
    entry: {
        "dependencies": ["./test-fastopt-entrypoint.js"],
        "test-fastopt": ["./hot-launcher.js"]
    },
    output: {
        path: __dirname,
        filename: "[name]-library.js",
        library: "library",
        libraryTarget: "var"
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                use: [
                    {
                        loader: "scalajs-friendly-source-map-loader",
                        options: {
                            skipFileURLWarnings: true, // or false, default is true
                            bundleHttp: true // or false, default is true
                        }
                    }],
                enforce: "pre"
            }
        ]
    },
    devtool: "source-map",
    plugins: [
        new HtmlWebpackPlugin({
            template: path.resolve(__dirname, "../../../../src/main/resources/public/index-fastopt.html"),
            inject: false
        })
    ],
    devServer: {
        proxy: {
            '/**': {  //catch all requests
                target: '/index.html',  //default target
                secure: false,
                bypass: function (req, res, opt) {
                    //your custom code to check for any exceptions
                    //console.log('bypass check', {req: req, res:res, opt: opt});
                    if (req.path.indexOf('/static/') !== -1 || req.path.indexOf('/public/') !== -1) {
                        return '/'
                    }

                    if (req.headers.accept.indexOf('html') !== -1) {
                        return '/index-fastopt.html';
                    }
                }
            }
        }
    }
});
