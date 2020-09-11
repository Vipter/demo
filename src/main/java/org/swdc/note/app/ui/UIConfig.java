package org.swdc.note.app.ui;

import javafx.scene.image.Image;
import javafx.scene.text.Font;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.swdc.note.app.configs.ConfigProp;
import org.swdc.note.app.configs.PropType;
import org.swdc.note.app.configs.ThemeImporter;
import org.swdc.note.app.util.UIUtil;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置和界面资源。
 * 提供各种资源供系统使用。
 *
 * 这里整合了开源的font-awesome资源，这里是前辈的MIT开源声明
 * The MIT License
 *
 * Copyright (c) 2016 Shell Technologies PTY LTD. http://au.shellpays.com
 *
 * You may obtain a copy of the License at
 *
 *       http://mit-license.org/
 *
 */
@Component
@PropertySource("file:configs/config.properties")
@ConfigurationProperties(prefix = "app")
@CommonsLog
public class UIConfig {

    @Getter
    private static Font fontIcon;

    @Getter
    private static Font fontIconSmall;

    @Getter
    private static Font fontIconLarge;

    @Getter
    private static Font fontIconVerySmall;

    @Getter
    private static Map<String, Character> awesomeMap;

    @Getter
    private static List<Image> imageIcons ;

    @Getter
    private static BufferedImage trayImage;

    @Autowired
    private ApplicationContext applicationContext;

    static {
        try{
            imageIcons = Arrays.asList(new Image(new ClassPathResource("icon/book16.png").getInputStream()),
                    new Image(new ClassPathResource("icon/book24.png").getInputStream()),
                    new Image(new ClassPathResource("icon/book32.png").getInputStream()),
                    new Image(new ClassPathResource("icon/book48.png").getInputStream()),
                    new Image(new ClassPathResource("icon/book64.png").getInputStream()),
                    new Image(new ClassPathResource("icon/book72.png").getInputStream()));
            trayImage = ImageIO.read(new ClassPathResource("icon/book16.png").getInputStream());
            fontIconSmall =  Font
                    .loadFont(new ClassPathResource("/style/fontawesome-webfont@4.5.0.ttf").getInputStream(), 14);
            fontIcon = Font
                    .loadFont(new ClassPathResource("/style/fontawesome-webfont@4.5.0.ttf").getInputStream(), 18);
            fontIconLarge = Font
                    .loadFont(new ClassPathResource("/style/fontawesome-webfont@4.5.0.ttf").getInputStream(), 24);
            fontIconVerySmall = Font
                    .loadFont(new ClassPathResource("/style/fontawesome-webfont@4.5.0.ttf").getInputStream(), 12);
            awesomeMap = new HashMap<>();
            awesomeMap.put("fa_500px", '\uf26e');
            awesomeMap.put("adjust", '\uf042');
            awesomeMap.put("adn", '\uf170');
            awesomeMap.put("align_center", '\uf037');
            awesomeMap.put("align_justify", '\uf039');
            awesomeMap.put("align_left", '\uf036');
            awesomeMap.put("align_right", '\uf038');
            awesomeMap.put("amazon", '\uf270');
            awesomeMap.put("ambulance", '\uf0f9');
            awesomeMap.put("anchor", '\uf13d');
            awesomeMap.put("android", '\uf17b');
            awesomeMap.put("angellist", '\uf209');
            awesomeMap.put("angle_double_down", '\uf103');
            awesomeMap.put("angle_double_left", '\uf100');
            awesomeMap.put("angle_double_right", '\uf101');
            awesomeMap.put("angle_double_up", '\uf102');
            awesomeMap.put("angle_down", '\uf107');
            awesomeMap.put("angle_left", '\uf104');
            awesomeMap.put("angle_right", '\uf105');
            awesomeMap.put("angle_up", '\uf106');
            awesomeMap.put("apple", '\uf179');
            awesomeMap.put("archive", '\uf187');
            awesomeMap.put("area_chart", '\uf1fe');
            awesomeMap.put("arrow_circle_down", '\uf0ab');
            awesomeMap.put("arrow_circle_left", '\uf0a8');
            awesomeMap.put("arrow_circle_alt_down", '\uf01a');
            awesomeMap.put("arrow_circle_alt_left", '\uf190');
            awesomeMap.put("arrow_circle_alt_right", '\uf18e');
            awesomeMap.put("arrow_circle_alt_up", '\uf01b');
            awesomeMap.put("arrow_circle_right", '\uf0a9');
            awesomeMap.put("arrow_circle_up", '\uf0aa');
            awesomeMap.put("arrow_down", '\uf063');
            awesomeMap.put("arrow_left", '\uf060');
            awesomeMap.put("arrow_right", '\uf061');
            awesomeMap.put("arrow_up", '\uf062');
            awesomeMap.put("arrows", '\uf047');
            awesomeMap.put("arrows_alt", '\uf0b2');
            awesomeMap.put("arrows_h", '\uf07e');
            awesomeMap.put("arrows_v", '\uf07d');
            awesomeMap.put("asterisk", '\uf069');
            awesomeMap.put("at", '\uf1fa');
            awesomeMap.put("automobile", '\uf1b9');
            awesomeMap.put("backward", '\uf04a');
            awesomeMap.put("balance_scale", '\uf24e');
            awesomeMap.put("ban", '\uf05e');
            awesomeMap.put("bank", '\uf19c');
            awesomeMap.put("bar_chart", '\uf080');
            awesomeMap.put("bar_chart_alt", '\uf080');
            awesomeMap.put("barcode", '\uf02a');
            awesomeMap.put("bars", '\uf0c9');
            awesomeMap.put("battery_0", '\uf244');
            awesomeMap.put("battery_1", '\uf243');
            awesomeMap.put("battery_2", '\uf242');
            awesomeMap.put("battery_3", '\uf241');
            awesomeMap.put("battery_4", '\uf240');
            awesomeMap.put("battery_empty", '\uf244');
            awesomeMap.put("battery_full", '\uf240');
            awesomeMap.put("battery_half", '\uf242');
            awesomeMap.put("battery_quarter", '\uf243');
            awesomeMap.put("battery_three_quarters", '\uf241');
            awesomeMap.put("bed", '\uf236');
            awesomeMap.put("beer", '\uf0fc');
            awesomeMap.put("behance", '\uf1b4');
            awesomeMap.put("behance_square", '\uf1b5');
            awesomeMap.put("bell", '\uf0f3');
            awesomeMap.put("bell_alt", '\uf0a2');
            awesomeMap.put("bell_slash", '\uf1f6');
            awesomeMap.put("bell_slash_alt", '\uf1f7');
            awesomeMap.put("bicycle", '\uf206');
            awesomeMap.put("binoculars", '\uf1e5');
            awesomeMap.put("birthday_cake", '\uf1fd');
            awesomeMap.put("bitbucket", '\uf171');
            awesomeMap.put("bitbucket_square", '\uf172');
            awesomeMap.put("bitcoin", '\uf15a');
            awesomeMap.put("black_tie", '\uf27e');
            awesomeMap.put("bluetooth", '\uf293');
            awesomeMap.put("bluetooth_b", '\uf294');
            awesomeMap.put("bold", '\uf032');
            awesomeMap.put("bolt", '\uf0e7');
            awesomeMap.put("bomb", '\uf1e2');
            awesomeMap.put("book", '\uf02d');
            awesomeMap.put("bookmark", '\uf02e');
            awesomeMap.put("bookmark_alt", '\uf097');
            awesomeMap.put("briefcase", '\uf0b1');
            awesomeMap.put("btc", '\uf15a');
            awesomeMap.put("bug", '\uf188');
            awesomeMap.put("building", '\uf1ad');
            awesomeMap.put("building_alt", '\uf0f7');
            awesomeMap.put("bullhorn", '\uf0a1');
            awesomeMap.put("bullseye", '\uf140');
            awesomeMap.put("bus", '\uf207');
            awesomeMap.put("buysellads", '\uf20d');
            awesomeMap.put("cab", '\uf1ba');
            awesomeMap.put("calculator", '\uf1ec');
            awesomeMap.put("calendar", '\uf073');
            awesomeMap.put("calendar_check_alt", '\uf274');
            awesomeMap.put("calendar_minus_alt", '\uf272');
            awesomeMap.put("calendar_alt", '\uf133');
            awesomeMap.put("calendar_plus_alt", '\uf271');
            awesomeMap.put("calendar_times_alt", '\uf273');
            awesomeMap.put("camera", '\uf030');
            awesomeMap.put("camera_retro", '\uf083');
            awesomeMap.put("car", '\uf1b9');
            awesomeMap.put("caret_down", '\uf0d7');
            awesomeMap.put("caret_left", '\uf0d9');
            awesomeMap.put("caret_right", '\uf0da');
            awesomeMap.put("caret_square_alt_down", '\uf150');
            awesomeMap.put("caret_square_alt_left", '\uf191');
            awesomeMap.put("caret_square_alt_right", '\uf152');
            awesomeMap.put("caret_square_alt_up", '\uf151');
            awesomeMap.put("caret_up", '\uf0d8');
            awesomeMap.put("cart_arrow_down", '\uf218');
            awesomeMap.put("cart_plus", '\uf217');
            awesomeMap.put("cc", '\uf20a');
            awesomeMap.put("cc_amex", '\uf1f3');
            awesomeMap.put("cc_diners_club", '\uf24c');
            awesomeMap.put("cc_discover", '\uf1f2');
            awesomeMap.put("cc_jcb", '\uf24b');
            awesomeMap.put("cc_mastercard", '\uf1f1');
            awesomeMap.put("cc_paypal", '\uf1f4');
            awesomeMap.put("cc_stripe", '\uf1f5');
            awesomeMap.put("cc_visa", '\uf1f0');
            awesomeMap.put("certificate", '\uf0a3');
            awesomeMap.put("chain", '\uf0c1');
            awesomeMap.put("chain_broken", '\uf127');
            awesomeMap.put("check", '\uf00c');
            awesomeMap.put("check_circle", '\uf058');
            awesomeMap.put("check_circle_alt", '\uf05d');
            awesomeMap.put("check_square", '\uf14a');
            awesomeMap.put("check_square_alt", '\uf046');
            awesomeMap.put("chevron_circle_down", '\uf13a');
            awesomeMap.put("chevron_circle_left", '\uf137');
            awesomeMap.put("chevron_circle_right", '\uf138');
            awesomeMap.put("chevron_circle_up", '\uf139');
            awesomeMap.put("chevron_down", '\uf078');
            awesomeMap.put("chevron_left", '\uf053');
            awesomeMap.put("chevron_right", '\uf054');
            awesomeMap.put("chevron_up", '\uf077');
            awesomeMap.put("child", '\uf1ae');
            awesomeMap.put("chrome", '\uf268');
            awesomeMap.put("circle", '\uf111');
            awesomeMap.put("circle_alt", '\uf10c');
            awesomeMap.put("circle_alt_notch", '\uf1ce');
            awesomeMap.put("circle_thin", '\uf1db');
            awesomeMap.put("clipboard", '\uf0ea');
            awesomeMap.put("clock_alt", '\uf017');
            awesomeMap.put("clone", '\uf24d');
            awesomeMap.put("close", '\uf00d');
            awesomeMap.put("cloud", '\uf0c2');
            awesomeMap.put("cloud_download", '\uf0ed');
            awesomeMap.put("cloud_upload", '\uf0ee');
            awesomeMap.put("cny", '\uf157');
            awesomeMap.put("code", '\uf121');
            awesomeMap.put("code_fork", '\uf126');
            awesomeMap.put("codepen", '\uf1cb');
            awesomeMap.put("codiepie", '\uf284');
            awesomeMap.put("coffee", '\uf0f4');
            awesomeMap.put("cog", '\uf013');
            awesomeMap.put("cogs", '\uf085');
            awesomeMap.put("columns", '\uf0db');
            awesomeMap.put("comment", '\uf075');
            awesomeMap.put("comment_alt", '\uf0e5');
            awesomeMap.put("commenting", '\uf27a');
            awesomeMap.put("commenting_alt", '\uf27b');
            awesomeMap.put("comments", '\uf086');
            awesomeMap.put("comments_alt", '\uf0e6');
            awesomeMap.put("compass", '\uf14e');
            awesomeMap.put("compress", '\uf066');
            awesomeMap.put("connectdevelop", '\uf20e');
            awesomeMap.put("contao", '\uf26d');
            awesomeMap.put("copy", '\uf0c5');
            awesomeMap.put("copyright", '\uf1f9');
            awesomeMap.put("creative_commons", '\uf25e');
            awesomeMap.put("credit_card", '\uf09d');
            awesomeMap.put("credit_card_alt", '\uf283');
            awesomeMap.put("crop", '\uf125');
            awesomeMap.put("crosshairs", '\uf05b');
            awesomeMap.put("css3", '\uf13c');
            awesomeMap.put("cube", '\uf1b2');
            awesomeMap.put("cubes", '\uf1b3');
            awesomeMap.put("cut", '\uf0c4');
            awesomeMap.put("cutlery", '\uf0f5');
            awesomeMap.put("dashboard", '\uf0e4');
            awesomeMap.put("dashcube", '\uf210');
            awesomeMap.put("database", '\uf1c0');
            awesomeMap.put("dedent", '\uf03b');
            awesomeMap.put("delicious", '\uf1a5');
            awesomeMap.put("desktop", '\uf108');
            awesomeMap.put("deviantart", '\uf1bd');
            awesomeMap.put("diamond", '\uf219');
            awesomeMap.put("digg", '\uf1a6');
            awesomeMap.put("dollar", '\uf155');
            awesomeMap.put("dot_circle_alt", '\uf192');
            awesomeMap.put("download", '\uf019');
            awesomeMap.put("dribbble", '\uf17d');
            awesomeMap.put("dropbox", '\uf16b');
            awesomeMap.put("drupal", '\uf1a9');
            awesomeMap.put("edge", '\uf282');
            awesomeMap.put("edit", '\uf044');
            awesomeMap.put("eject", '\uf052');
            awesomeMap.put("ellipsis_h", '\uf141');
            awesomeMap.put("ellipsis_v", '\uf142');
            awesomeMap.put("empire", '\uf1d1');
            awesomeMap.put("envelope", '\uf0e0');
            awesomeMap.put("envelope_alt", '\uf003');
            awesomeMap.put("envelope_square", '\uf199');
            awesomeMap.put("eraser", '\uf12d');
            awesomeMap.put("eur", '\uf153');
            awesomeMap.put("euro", '\uf153');
            awesomeMap.put("exchange", '\uf0ec');
            awesomeMap.put("exclamation", '\uf12a');
            awesomeMap.put("exclamation_circle", '\uf06a');
            awesomeMap.put("exclamation_triangle", '\uf071');
            awesomeMap.put("expand", '\uf065');
            awesomeMap.put("expeditedssl", '\uf23e');
            awesomeMap.put("external_link", '\uf08e');
            awesomeMap.put("external_link_square", '\uf14c');
            awesomeMap.put("eye", '\uf06e');
            awesomeMap.put("eye_slash", '\uf070');
            awesomeMap.put("eyedropper", '\uf1fb');
            awesomeMap.put("facebook", '\uf09a');
            awesomeMap.put("facebook_f", '\uf09a');
            awesomeMap.put("facebook_official", '\uf230');
            awesomeMap.put("facebook_square", '\uf082');
            awesomeMap.put("fast_backward", '\uf049');
            awesomeMap.put("fast_forward", '\uf050');
            awesomeMap.put("fax", '\uf1ac');
            awesomeMap.put("feed", '\uf09e');
            awesomeMap.put("female", '\uf182');
            awesomeMap.put("fighter_jet", '\uf0fb');
            awesomeMap.put("file", '\uf15b');
            awesomeMap.put("file_archive_alt", '\uf1c6');
            awesomeMap.put("file_audio_alt", '\uf1c7');
            awesomeMap.put("file_code_alt", '\uf1c9');
            awesomeMap.put("file_excel_alt", '\uf1c3');
            awesomeMap.put("file_image_alt", '\uf1c5');
            awesomeMap.put("file_movie_alt", '\uf1c8');
            awesomeMap.put("file_alt", '\uf016');
            awesomeMap.put("file_pdf_alt", '\uf1c1');
            awesomeMap.put("file_photo_alt", '\uf1c5');
            awesomeMap.put("file_picture_alt", '\uf1c5');
            awesomeMap.put("file_powerpoint_alt", '\uf1c4');
            awesomeMap.put("file_sound_alt", '\uf1c7');
            awesomeMap.put("file_text", '\uf15c');
            awesomeMap.put("file_text_alt", '\uf0f6');
            awesomeMap.put("file_video_alt", '\uf1c8');
            awesomeMap.put("file_word_alt", '\uf1c2');
            awesomeMap.put("file_zip_alt", '\uf1c6');
            awesomeMap.put("files_alt", '\uf0c5');
            awesomeMap.put("film", '\uf008');
            awesomeMap.put("filter", '\uf0b0');
            awesomeMap.put("fire", '\uf06d');
            awesomeMap.put("fire_extinguisher", '\uf134');
            awesomeMap.put("firefox", '\uf269');
            awesomeMap.put("flag", '\uf024');
            awesomeMap.put("flag_checkered", '\uf11e');
            awesomeMap.put("flag_alt", '\uf11d');
            awesomeMap.put("flash", '\uf0e7');
            awesomeMap.put("flask", '\uf0c3');
            awesomeMap.put("flickr", '\uf16e');
            awesomeMap.put("floppy_alt", '\uf0c7');
            awesomeMap.put("folder", '\uf07b');
            awesomeMap.put("folder_alt", '\uf114');
            awesomeMap.put("folder_open", '\uf07c');
            awesomeMap.put("folder_open_alt", '\uf115');
            awesomeMap.put("font", '\uf031');
            awesomeMap.put("fonticons", '\uf280');
            awesomeMap.put("fort_awesome", '\uf286');
            awesomeMap.put("forumbee", '\uf211');
            awesomeMap.put("forward", '\uf04e');
            awesomeMap.put("foursquare", '\uf180');
            awesomeMap.put("frown_alt", '\uf119');
            awesomeMap.put("futbol_alt", '\uf1e3');
            awesomeMap.put("gamepad", '\uf11b');
            awesomeMap.put("gavel", '\uf0e3');
            awesomeMap.put("gbp", '\uf154');
            awesomeMap.put("ge", '\uf1d1');
            awesomeMap.put("gear", '\uf013');
            awesomeMap.put("gears", '\uf085');
            awesomeMap.put("genderless", '\uf22d');
            awesomeMap.put("get_pocket", '\uf265');
            awesomeMap.put("gg", '\uf260');
            awesomeMap.put("gg_circle", '\uf261');
            awesomeMap.put("gift", '\uf06b');
            awesomeMap.put("git", '\uf1d3');
            awesomeMap.put("git_square", '\uf1d2');
            awesomeMap.put("github", '\uf09b');
            awesomeMap.put("github_alt", '\uf113');
            awesomeMap.put("github_square", '\uf092');
            awesomeMap.put("gittip", '\uf184');
            awesomeMap.put("glass", '\uf000');
            awesomeMap.put("globe", '\uf0ac');
            awesomeMap.put("google", '\uf1a0');
            awesomeMap.put("google_plus", '\uf0d5');
            awesomeMap.put("google_plus_square", '\uf0d4');
            awesomeMap.put("google_wallet", '\uf1ee');
            awesomeMap.put("graduation_cap", '\uf19d');
            awesomeMap.put("gratipay", '\uf184');
            awesomeMap.put("group", '\uf0c0');
            awesomeMap.put("h_square", '\uf0fd');
            awesomeMap.put("hacker_news", '\uf1d4');
            awesomeMap.put("hand_grab_alt", '\uf255');
            awesomeMap.put("hand_lizard_alt", '\uf258');
            awesomeMap.put("hand_alt_down", '\uf0a7');
            awesomeMap.put("hand_alt_left", '\uf0a5');
            awesomeMap.put("hand_alt_right", '\uf0a4');
            awesomeMap.put("hand_alt_up", '\uf0a6');
            awesomeMap.put("hand_paper_alt", '\uf256');
            awesomeMap.put("hand_peace_alt", '\uf25b');
            awesomeMap.put("hand_pointer_alt", '\uf25a');
            awesomeMap.put("hand_rock_alt", '\uf255');
            awesomeMap.put("hand_scissors_alt", '\uf257');
            awesomeMap.put("hand_spock_alt", '\uf259');
            awesomeMap.put("hand_stop_alt", '\uf256');
            awesomeMap.put("hashtag", '\uf292');
            awesomeMap.put("hdd_alt", '\uf0a0');
            awesomeMap.put("header", '\uf1dc');
            awesomeMap.put("headphones", '\uf025');
            awesomeMap.put("heart", '\uf004');
            awesomeMap.put("heart_alt", '\uf08a');
            awesomeMap.put("heartbeat", '\uf21e');
            awesomeMap.put("history", '\uf1da');
            awesomeMap.put("home", '\uf015');
            awesomeMap.put("hospital_alt", '\uf0f8');
            awesomeMap.put("hotel", '\uf236');
            awesomeMap.put("hourglass", '\uf254');
            awesomeMap.put("hourglass_1", '\uf250');
            awesomeMap.put("hourglass_2", '\uf252');
            awesomeMap.put("hourglass_3", '\uf253');
            awesomeMap.put("hourglass_end", '\uf253');
            awesomeMap.put("hourglass_half", '\uf252');
            awesomeMap.put("hourglass_alt", '\uf250');
            awesomeMap.put("hourglass_start", '\uf251');
            awesomeMap.put("houzz", '\uf27c');
            awesomeMap.put("html5", '\uf13b');
            awesomeMap.put("i_cursor", '\uf246');
            awesomeMap.put("ils", '\uf20b');
            awesomeMap.put("image", '\uf03e');
            awesomeMap.put("inbox", '\uf01c');
            awesomeMap.put("indent", '\uf03c');
            awesomeMap.put("industry", '\uf275');
            awesomeMap.put("info", '\uf129');
            awesomeMap.put("info_circle", '\uf05a');
            awesomeMap.put("inr", '\uf156');
            awesomeMap.put("instagram", '\uf16d');
            awesomeMap.put("institution", '\uf19c');
            awesomeMap.put("internet_explorer", '\uf26b');
            awesomeMap.put("intersex", '\uf224');
            awesomeMap.put("ioxhost", '\uf208');
            awesomeMap.put("italic", '\uf033');
            awesomeMap.put("joomla", '\uf1aa');
            awesomeMap.put("jpy", '\uf157');
            awesomeMap.put("jsfiddle", '\uf1cc');
            awesomeMap.put("key", '\uf084');
            awesomeMap.put("keyboard_alt", '\uf11c');
            awesomeMap.put("krw", '\uf159');
            awesomeMap.put("language", '\uf1ab');
            awesomeMap.put("laptop", '\uf109');
            awesomeMap.put("lastfm", '\uf202');
            awesomeMap.put("lastfm_square", '\uf203');
            awesomeMap.put("leaf", '\uf06c');
            awesomeMap.put("leanpub", '\uf212');
            awesomeMap.put("legal", '\uf0e3');
            awesomeMap.put("lemon_alt", '\uf094');
            awesomeMap.put("level_down", '\uf149');
            awesomeMap.put("level_up", '\uf148');
            awesomeMap.put("life_bouy", '\uf1cd');
            awesomeMap.put("life_buoy", '\uf1cd');
            awesomeMap.put("life_ring", '\uf1cd');
            awesomeMap.put("life_saver", '\uf1cd');
            awesomeMap.put("lightbulb_alt", '\uf0eb');
            awesomeMap.put("line_chart", '\uf201');
            awesomeMap.put("link", '\uf0c1');
            awesomeMap.put("linkedin", '\uf0e1');
            awesomeMap.put("linkedin_square", '\uf08c');
            awesomeMap.put("linux", '\uf17c');
            awesomeMap.put("list", '\uf03a');
            awesomeMap.put("list_alt", '\uf022');
            awesomeMap.put("list_ol", '\uf0cb');
            awesomeMap.put("list_ul", '\uf0ca');
            awesomeMap.put("location_arrow", '\uf124');
            awesomeMap.put("lock", '\uf023');
            awesomeMap.put("long_arrow_down", '\uf175');
            awesomeMap.put("long_arrow_left", '\uf177');
            awesomeMap.put("long_arrow_right", '\uf178');
            awesomeMap.put("long_arrow_up", '\uf176');
            awesomeMap.put("magic", '\uf0d0');
            awesomeMap.put("magnet", '\uf076');
            awesomeMap.put("mail_forward", '\uf064');
            awesomeMap.put("mail_reply", '\uf112');
            awesomeMap.put("mail_reply_all", '\uf122');
            awesomeMap.put("male", '\uf183');
            awesomeMap.put("awesomeMap", '\uf279');
            awesomeMap.put("map_marker", '\uf041');
            awesomeMap.put("map_alt", '\uf278');
            awesomeMap.put("map_pin", '\uf276');
            awesomeMap.put("map_signs", '\uf277');
            awesomeMap.put("mars", '\uf222');
            awesomeMap.put("mars_double", '\uf227');
            awesomeMap.put("mars_stroke", '\uf229');
            awesomeMap.put("mars_stroke_h", '\uf22b');
            awesomeMap.put("mars_stroke_v", '\uf22a');
            awesomeMap.put("maxcdn", '\uf136');
            awesomeMap.put("meanpath", '\uf20c');
            awesomeMap.put("medium", '\uf23a');
            awesomeMap.put("medkit", '\uf0fa');
            awesomeMap.put("meh_alt", '\uf11a');
            awesomeMap.put("mercury", '\uf223');
            awesomeMap.put("microphone", '\uf130');
            awesomeMap.put("microphone_slash", '\uf131');
            awesomeMap.put("minus", '\uf068');
            awesomeMap.put("minus_circle", '\uf056');
            awesomeMap.put("minus_square", '\uf146');
            awesomeMap.put("minus_square_alt", '\uf147');
            awesomeMap.put("mixcloud", '\uf289');
            awesomeMap.put("mobile", '\uf10b');
            awesomeMap.put("mobile_phone", '\uf10b');
            awesomeMap.put("modx", '\uf285');
            awesomeMap.put("money", '\uf0d6');
            awesomeMap.put("moon_alt", '\uf186');
            awesomeMap.put("mortar_board", '\uf19d');
            awesomeMap.put("motorcycle", '\uf21c');
            awesomeMap.put("mouse_pointer", '\uf245');
            awesomeMap.put("music", '\uf001');
            awesomeMap.put("navicon", '\uf0c9');
            awesomeMap.put("neuter", '\uf22c');
            awesomeMap.put("newspaper_alt", '\uf1ea');
            awesomeMap.put("object_group", '\uf247');
            awesomeMap.put("object_ungroup", '\uf248');
            awesomeMap.put("odnoklassniki", '\uf263');
            awesomeMap.put("odnoklassniki_square", '\uf264');
            awesomeMap.put("opencart", '\uf23d');
            awesomeMap.put("openid", '\uf19b');
            awesomeMap.put("opera", '\uf26a');
            awesomeMap.put("optin_monster", '\uf23c');
            awesomeMap.put("outdent", '\uf03b');
            awesomeMap.put("pagelines", '\uf18c');
            awesomeMap.put("paint_brush", '\uf1fc');
            awesomeMap.put("paper_plane", '\uf1d8');
            awesomeMap.put("paper_plane_alt", '\uf1d9');
            awesomeMap.put("paperclip", '\uf0c6');
            awesomeMap.put("paragraph", '\uf1dd');
            awesomeMap.put("paste", '\uf0ea');
            awesomeMap.put("pause", '\uf04c');
            awesomeMap.put("pause_circle", '\uf28b');
            awesomeMap.put("pause_circle_alt", '\uf28c');
            awesomeMap.put("paw", '\uf1b0');
            awesomeMap.put("paypal", '\uf1ed');
            awesomeMap.put("pencil", '\uf040');
            awesomeMap.put("pencil_square", '\uf14b');
            awesomeMap.put("pencil_square_alt", '\uf044');
            awesomeMap.put("percent", '\uf295');
            awesomeMap.put("phone", '\uf095');
            awesomeMap.put("phone_square", '\uf098');
            awesomeMap.put("photo", '\uf03e');
            awesomeMap.put("picture_alt", '\uf03e');
            awesomeMap.put("pie_chart", '\uf200');
            awesomeMap.put("pied_piper", '\uf1a7');
            awesomeMap.put("pied_piper_alt", '\uf1a8');
            awesomeMap.put("pinterest", '\uf0d2');
            awesomeMap.put("pinterest_p", '\uf231');
            awesomeMap.put("pinterest_square", '\uf0d3');
            awesomeMap.put("plane", '\uf072');
            awesomeMap.put("play", '\uf04b');
            awesomeMap.put("play_circle", '\uf144');
            awesomeMap.put("play_circle_alt", '\uf01d');
            awesomeMap.put("plug", '\uf1e6');
            awesomeMap.put("plus", '\uf067');
            awesomeMap.put("plus_circle", '\uf055');
            awesomeMap.put("plus_square", '\uf0fe');
            awesomeMap.put("plus_square_alt", '\uf196');
            awesomeMap.put("power_off", '\uf011');
            awesomeMap.put("print", '\uf02f');
            awesomeMap.put("product_hunt", '\uf288');
            awesomeMap.put("puzzle_piece", '\uf12e');
            awesomeMap.put("qq", '\uf1d6');
            awesomeMap.put("qrcode", '\uf029');
            awesomeMap.put("question", '\uf128');
            awesomeMap.put("question_circle", '\uf059');
            awesomeMap.put("quote_left", '\uf10d');
            awesomeMap.put("quote_right", '\uf10e');
            awesomeMap.put("ra", '\uf1d0');
            awesomeMap.put("random", '\uf074');
            awesomeMap.put("rebel", '\uf1d0');
            awesomeMap.put("recycle", '\uf1b8');
            awesomeMap.put("reddit", '\uf1a1');
            awesomeMap.put("reddit_alien", '\uf281');
            awesomeMap.put("reddit_square", '\uf1a2');
            awesomeMap.put("refresh", '\uf021');
            awesomeMap.put("registered", '\uf25d');
            awesomeMap.put("remove", '\uf00d');
            awesomeMap.put("renren", '\uf18b');
            awesomeMap.put("reorder", '\uf0c9');
            awesomeMap.put("repeat", '\uf01e');
            awesomeMap.put("reply", '\uf112');
            awesomeMap.put("reply_all", '\uf122');
            awesomeMap.put("retweet", '\uf079');
            awesomeMap.put("rmb", '\uf157');
            awesomeMap.put("road", '\uf018');
            awesomeMap.put("rocket", '\uf135');
            awesomeMap.put("rotate_left", '\uf0e2');
            awesomeMap.put("rotate_right", '\uf01e');
            awesomeMap.put("rouble", '\uf158');
            awesomeMap.put("rss", '\uf09e');
            awesomeMap.put("rss_square", '\uf143');
            awesomeMap.put("rub", '\uf158');
            awesomeMap.put("ruble", '\uf158');
            awesomeMap.put("rupee", '\uf156');
            awesomeMap.put("safari", '\uf267');
            awesomeMap.put("save", '\uf0c7');
            awesomeMap.put("scissors", '\uf0c4');
            awesomeMap.put("scribd", '\uf28a');
            awesomeMap.put("search", '\uf002');
            awesomeMap.put("search_minus", '\uf010');
            awesomeMap.put("search_plus", '\uf00e');
            awesomeMap.put("sellsy", '\uf213');
            awesomeMap.put("send", '\uf1d8');
            awesomeMap.put("send_alt", '\uf1d9');
            awesomeMap.put("server", '\uf233');
            awesomeMap.put("share", '\uf064');
            awesomeMap.put("share_alt", '\uf1e0');
            awesomeMap.put("share_alt_square", '\uf1e1');
            awesomeMap.put("share_square", '\uf14d');
            awesomeMap.put("share_square_alt", '\uf045');
            awesomeMap.put("shekel", '\uf20b');
            awesomeMap.put("sheqel", '\uf20b');
            awesomeMap.put("shield", '\uf132');
            awesomeMap.put("ship", '\uf21a');
            awesomeMap.put("shirtsinbulk", '\uf214');
            awesomeMap.put("shopping_bag", '\uf290');
            awesomeMap.put("shopping_basket", '\uf291');
            awesomeMap.put("shopping_cart", '\uf07a');
            awesomeMap.put("sign_in", '\uf090');
            awesomeMap.put("sign_out", '\uf08b');
            awesomeMap.put("signal", '\uf012');
            awesomeMap.put("simplybuilt", '\uf215');
            awesomeMap.put("sitemap", '\uf0e8');
            awesomeMap.put("skyatlas", '\uf216');
            awesomeMap.put("skype", '\uf17e');
            awesomeMap.put("slack", '\uf198');
            awesomeMap.put("sliders", '\uf1de');
            awesomeMap.put("slideshare", '\uf1e7');
            awesomeMap.put("smile_alt", '\uf118');
            awesomeMap.put("soccer_ball_alt", '\uf1e3');
            awesomeMap.put("sort", '\uf0dc');
            awesomeMap.put("sort_alpha_asc", '\uf15d');
            awesomeMap.put("sort_alpha_desc", '\uf15e');
            awesomeMap.put("sort_amount_asc", '\uf160');
            awesomeMap.put("sort_amount_desc", '\uf161');
            awesomeMap.put("sort_asc", '\uf0de');
            awesomeMap.put("sort_desc", '\uf0dd');
            awesomeMap.put("sort_down", '\uf0dd');
            awesomeMap.put("sort_numeric_asc", '\uf162');
            awesomeMap.put("sort_numeric_desc", '\uf163');
            awesomeMap.put("sort_up", '\uf0de');
            awesomeMap.put("soundcloud", '\uf1be');
            awesomeMap.put("space_shuttle", '\uf197');
            awesomeMap.put("spinner", '\uf110');
            awesomeMap.put("spoon", '\uf1b1');
            awesomeMap.put("spotify", '\uf1bc');
            awesomeMap.put("square", '\uf0c8');
            awesomeMap.put("square_alt", '\uf096');
            awesomeMap.put("stack_exchange", '\uf18d');
            awesomeMap.put("stack_overflow", '\uf16c');
            awesomeMap.put("star", '\uf005');
            awesomeMap.put("star_half", '\uf089');
            awesomeMap.put("star_half_empty", '\uf123');
            awesomeMap.put("star_half_full", '\uf123');
            awesomeMap.put("star_half_alt", '\uf123');
            awesomeMap.put("star_alt", '\uf006');
            awesomeMap.put("steam", '\uf1b6');
            awesomeMap.put("steam_square", '\uf1b7');
            awesomeMap.put("step_backward", '\uf048');
            awesomeMap.put("step_forward", '\uf051');
            awesomeMap.put("stethoscope", '\uf0f1');
            awesomeMap.put("sticky_note", '\uf249');
            awesomeMap.put("sticky_note_alt", '\uf24a');
            awesomeMap.put("stop", '\uf04d');
            awesomeMap.put("stop_circle", '\uf28d');
            awesomeMap.put("stop_circle_alt", '\uf28e');
            awesomeMap.put("street_view", '\uf21d');
            awesomeMap.put("strikethrough", '\uf0cc');
            awesomeMap.put("stumbleupon", '\uf1a4');
            awesomeMap.put("stumbleupon_circle", '\uf1a3');
            awesomeMap.put("subscript", '\uf12c');
            awesomeMap.put("subway", '\uf239');
            awesomeMap.put("suitcase", '\uf0f2');
            awesomeMap.put("sun_alt", '\uf185');
            awesomeMap.put("superscript", '\uf12b');
            awesomeMap.put("support", '\uf1cd');
            awesomeMap.put("table", '\uf0ce');
            awesomeMap.put("tablet", '\uf10a');
            awesomeMap.put("tachometer", '\uf0e4');
            awesomeMap.put("tag", '\uf02b');
            awesomeMap.put("tags", '\uf02c');
            awesomeMap.put("tasks", '\uf0ae');
            awesomeMap.put("taxi", '\uf1ba');
            awesomeMap.put("television", '\uf26c');
            awesomeMap.put("tencent_weibo", '\uf1d5');
            awesomeMap.put("terminal", '\uf120');
            awesomeMap.put("text_height", '\uf034');
            awesomeMap.put("text_width", '\uf035');
            awesomeMap.put("th", '\uf00a');
            awesomeMap.put("th_large", '\uf009');
            awesomeMap.put("th_list", '\uf00b');
            awesomeMap.put("thumb_tack", '\uf08d');
            awesomeMap.put("thumbs_down", '\uf165');
            awesomeMap.put("thumbs_alt_down", '\uf088');
            awesomeMap.put("thumbs_alt_up", '\uf087');
            awesomeMap.put("thumbs_up", '\uf164');
            awesomeMap.put("ticket", '\uf145');
            awesomeMap.put("times", '\uf00d');
            awesomeMap.put("times_circle", '\uf057');
            awesomeMap.put("times_circle_alt", '\uf05c');
            awesomeMap.put("tint", '\uf043');
            awesomeMap.put("toggle_down", '\uf150');
            awesomeMap.put("toggle_left", '\uf191');
            awesomeMap.put("toggle_off", '\uf204');
            awesomeMap.put("toggle_on", '\uf205');
            awesomeMap.put("toggle_right", '\uf152');
            awesomeMap.put("toggle_up", '\uf151');
            awesomeMap.put("trademark", '\uf25c');
            awesomeMap.put("train", '\uf238');
            awesomeMap.put("transgender", '\uf224');
            awesomeMap.put("transgender_alt", '\uf225');
            awesomeMap.put("trash", '\uf1f8');
            awesomeMap.put("trash_alt", '\uf014');
            awesomeMap.put("tree", '\uf1bb');
            awesomeMap.put("trello", '\uf181');
            awesomeMap.put("tripadvisor", '\uf262');
            awesomeMap.put("trophy", '\uf091');
            awesomeMap.put("truck", '\uf0d1');
            awesomeMap.put("try", '\uf195');
            awesomeMap.put("tty", '\uf1e4');
            awesomeMap.put("tumblr", '\uf173');
            awesomeMap.put("tumblr_square", '\uf174');
            awesomeMap.put("turkish_lira", '\uf195');
            awesomeMap.put("tv", '\uf26c');
            awesomeMap.put("twitch", '\uf1e8');
            awesomeMap.put("twitter", '\uf099');
            awesomeMap.put("twitter_square", '\uf081');
            awesomeMap.put("umbrella", '\uf0e9');
            awesomeMap.put("underline", '\uf0cd');
            awesomeMap.put("undo", '\uf0e2');
            awesomeMap.put("university", '\uf19c');
            awesomeMap.put("unlink", '\uf127');
            awesomeMap.put("unlock", '\uf09c');
            awesomeMap.put("unlock_alt", '\uf13e');
            awesomeMap.put("unsorted", '\uf0dc');
            awesomeMap.put("upload", '\uf093');
            awesomeMap.put("usb", '\uf287');
            awesomeMap.put("usd", '\uf155');
            awesomeMap.put("user", '\uf007');
            awesomeMap.put("user_md", '\uf0f0');
            awesomeMap.put("user_plus", '\uf234');
            awesomeMap.put("user_secret", '\uf21b');
            awesomeMap.put("user_times", '\uf235');
            awesomeMap.put("users", '\uf0c0');
            awesomeMap.put("venus", '\uf221');
            awesomeMap.put("venus_double", '\uf226');
            awesomeMap.put("venus_mars", '\uf228');
            awesomeMap.put("viacoin", '\uf237');
            awesomeMap.put("video_camera", '\uf03d');
            awesomeMap.put("vimeo", '\uf27d');
            awesomeMap.put("vimeo_square", '\uf194');
            awesomeMap.put("vine", '\uf1ca');
            awesomeMap.put("vk", '\uf189');
            awesomeMap.put("volume_down", '\uf027');
            awesomeMap.put("volume_off", '\uf026');
            awesomeMap.put("volume_up", '\uf028');
            awesomeMap.put("warning", '\uf071');
            awesomeMap.put("wechat", '\uf1d7');
            awesomeMap.put("weibo", '\uf18a');
            awesomeMap.put("weixin", '\uf1d7');
            awesomeMap.put("whatsapp", '\uf232');
            awesomeMap.put("wheelchair", '\uf193');
            awesomeMap.put("wifi", '\uf1eb');
            awesomeMap.put("wikipedia_w", '\uf266');
            awesomeMap.put("windows", '\uf17a');
            awesomeMap.put("won", '\uf159');
            awesomeMap.put("wordpress", '\uf19a');
            awesomeMap.put("wrench", '\uf0ad');
            awesomeMap.put("xing", '\uf168');
            awesomeMap.put("xing_square", '\uf169');
            awesomeMap.put("y_combinator", '\uf23b');
            awesomeMap.put("y_combinator_square", '\uf1d4');
            awesomeMap.put("yahoo", '\uf19e');
            awesomeMap.put("yc", '\uf23b');
            awesomeMap.put("yc_square", '\uf1d4');
            awesomeMap.put("yelp", '\uf1e9');
            awesomeMap.put("yen", '\uf157');
            awesomeMap.put("youtube", '\uf167');
            awesomeMap.put("youtube_play", '\uf16a');
            awesomeMap.put("youtube_square", '\uf166');
        }catch (Exception e){
        }
    }

    @Getter
    private static final String configLocation = "file:configs/";

    @Getter
    private java.awt.Font awtFont;

    @Getter
    @Setter
    @ConfigProp(name = "背景图片",value = "configs/res",tooltip = "应用的背景图片",
            propName = "background",type = PropType.FILE_SELECT_IMPORTABLE)
    private String background;

    /**
     * 是否启用后台运行
     */
    @Getter
    @Setter
    @ConfigProp(name = "允许后台运行", value = "", type = PropType.CHECK,
            propName = "run-in-background",tooltip = "如果不允许后台运行，那么关闭窗口后会退出。")
    private Boolean runInBackground;

    @Getter
    @Setter
    @ConfigProp(name = "主题", value = "configs/theme", type = PropType.FOLDER_SELECT_IMPORTABLE,
            propName = "theme", tooltip = "工程使用的主题。", importer = ThemeImporter.class)
    private String theme;

    @Getter
    @Setter
    @ConfigProp(name = "编辑器字体大小", value = "42", tooltip = "编辑器的字体的大小。",
            type = PropType.NUMBER_SELECTABLE, propName = "editor-font-size")
    private Integer editorFontSize;

    @Getter
    @Setter
    @ConfigProp(name = "渲染字体大小", value = "42", tooltip = "显示的字体的大小。",
            type = PropType.NUMBER_SELECTABLE, propName = "render-font-size")
    private Integer renderFontSize;

    @Getter
    @Setter
    @ConfigProp(name = "标题字体大小", value = "42", tooltip = "文档中标题的字体的大小。",
            type = PropType.NUMBER_SELECTABLE, propName = "header-font-size")
    private Integer headerFontSize;

    @Getter
    @Setter
    @ConfigProp(name = "渲染字体阴影", value = "", tooltip = "渲染字体阴影效果。",
            type = PropType.CHECK, propName = "text-shadow")
    private Boolean textShadow;

    @Getter
    private String mdStyleContent;

    @Getter
    @Setter
    private Boolean winStyledPopup;

    @PostConstruct
    private void init() throws Exception{
        if (this.theme == null|| this.theme.equals("")||this.theme.equals("default")){
            mdStyleContent = UIUtil.readFileAsText(new ClassPathResource("/style/markdown.css").getInputStream());
        }else{
            mdStyleContent = UIUtil.readFileAsText((InputStream) new FileInputStream("./configs/theme/"+theme+"/"+theme+".md.css"));
        }
        File fontFile = new File("./configs/theme/"+theme+"/font.ttf");
        if (fontFile.exists()) {
            Font font = Font.loadFont(new FileInputStream("./configs/theme/"+theme+"/font.ttf"), 18);
            awtFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new File("./configs/theme/"+theme+"/font.ttf"));
            log.info("custom font " + font.getFamily() + " loaded");
        }
        String osName = System.getProperty("os.name");
        if (osName != null && osName.toLowerCase().startsWith("win")) {
            this.winStyledPopup = true;
        }
    }

    public <T extends ApplicationEvent> void publishEvent (T event){
        applicationContext.publishEvent(event);
    }

    public <T> T getComponent(Class<T> clazz){
        Scope scope = clazz.getAnnotation(Scope.class);
        if(scope.value().equals("prototype")){
            return applicationContext.getBean(clazz);
        }
       throw new RuntimeException("此方法仅用于获取prototype的spring组件。");
    }

}