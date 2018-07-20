var merge = require('webpack-merge');
var core = require('./webpack-core.config.js');
var webpack = require("webpack");
var path = require("path");
var HtmlWebpackPlugin = require('html-webpack-plugin');
var BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;


module.exports = merge(core, {
    mode: "production",
    entry: {
        "test-opt": [path.resolve(__dirname, "./opt-launcher.js")]
    },
    output: {
        path: path.resolve(__dirname, "../../../../build"),
        filename: "[name].[hash].js",
        chunkFilename: '[name].[hash].js'
    },
    optimization: {
        splitChunks: {
            chunks: 'all'
        }
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.resolve(__dirname, "../../../../src/main/resources/public/index.html")
        }),
        new webpack.DefinePlugin({
            'process.env': {
                NODE_ENV: JSON.stringify('production')
            }
        }),
        new BundleAnalyzerPlugin()
    ]
});
