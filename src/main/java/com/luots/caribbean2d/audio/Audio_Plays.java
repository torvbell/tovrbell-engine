package com.luots.caribbean2d.audio;

/* ************************************************************************
 *
 * Copyright (C) 2020 dahan All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ************************************************************************/

/*
 * Creates on 2020/12/30.
 */

import com.luots.caribbean2d.audio.type.Play_Mp3;
import com.luots.caribbean2d.exception.Unknown_Type_Error;
import com.luots.caribbean2d.utils.Files;

import java.io.File;
import java.util.Locale;

/**
 * 音频播放对象生成工具类
 *
 * @author tiansheng
 */
public class Audio_Plays
{

    private static final String AUDIO_DIR = "resources/audio";

    /**
     * 音频格式
     */
    public enum AudioType
    {
        MP3, WAV
    }

    /**
     * 生成对应的音频播放器
     *
     * @return AudioPlay实例
     */
    public static Audio_Play getAudioPlayInstance(File audiof)
    {

        String extension = Files.getExtension(audiof);
        AudioType audioType = AudioType.valueOf(extension.toUpperCase(Locale.ROOT));

        try
        {
            switch (audioType)
            {
                case MP3:
                    return new Play_Mp3(audiof);
                default: {
                    throw new Unknown_Type_Error(String.format("不支持音频格式: [%s]", extension));
                }
            }
        }catch (Exception e) {
            throw new Unknown_Type_Error(String.format("音频加载失败: [%s]", audiof.getAbsolutePath()), e);
        }

    }

}
