package com.app.mytoolbox.player.ui;


public class DTPlayerNew {

//    private static final String TAG = "DTPlayer";
//    public Thread tapThread;
//    private static Asset asset;
//    private static int episodeNumber;
//    boolean lockEnable = false;
//    List<TrackItem> trackItemList;
//    boolean adRunning = false;
//    TrackItem[] captionList;
//    TrackItem[] audioList;
//    private boolean isAdsRunning = false;
//    boolean isVideoError = false;
//    boolean hasPostRoll = false;
//    boolean hasMidRoll = false;
//    boolean allAdsCompleted = false;
//    boolean isWaitingBinge = false;
//    boolean hasPreRoll = false;
//    boolean isPlayerEnded = false;
//    boolean isAdPause = false;
//    private int totalEpisode = 0;
//    boolean exitPlayer = false;
//    boolean isPause = false;
//    private boolean isAdError = false;
//    String startTimeStamp;
//    String endTimeStamp;
//    PendingIntent pendingIntent = null;
//    AlarmManager alarmManager;
//    Intent myIntent;
//    long reminderDateTimeInMilliseconds = 000;
//    int mm;
//    int yr;
//    int ddy;
//    ArrayList<ParentalLevels> parentalLevels;
//    private BottomSheetDialog dialog;
//    private BottomSheetDialog bottomSheetDialog;
//    private Dialog dialogQuality;
//    private BottomSheetDialog dialogCaption;
//    private BottomSheetDialog dialogAudio;
//    private Runnable myRunnable;
//    private PowerManager powerManager;
//    private PowerManager.WakeLock wakeLock;
//    private DTPlayerViewModel viewModel;
//    private int handlerTime = 4000;
//    private boolean timer = true;
//    private Handler timeHandler;
//    private String trackName = "";
//    private String audioTrackName = "";
//    private String captionName = "";
//    private String image_url;
//    private int assetType;
//    private boolean isPlayerStart = false;
//    private int isPurchased = 1;
//    private String playerURL;
//    private Asset playerAsset;
//    private String programName1 = "";
//    private int playerProgress;
//    private Player runningPlayer;
//    private String selectedTrack;
//    private int assetPosition = 0;
//    private boolean isPlayerIconClick = false;
//    private boolean isError = false;
//    private BaseActivity baseActivity;
//    private boolean isLiveChannel = false;
//    private boolean isDtvAdded = false;
//    private long lastClickTime = 0;
//    private Swipe swipe;
//    private AudioManager audioManager;
//    private Map<String, MultilingualStringValueArray> map;
//    private List<RailCommonData> railList;
//    private boolean isSkipCreditVisible = false;
//    private boolean isUserGeneratedCredit = false;
//    private Handler handler1 = new Handler();
//    Bitmap myBitmap;
//    HashMap<String, Bitmap> spritesHashMap = new HashMap<>();
//    HashMap<String, Bitmap> previewImagesHashMap;
//    private String scrubberUrl = "";
//    ObjectAnimator objectAnimator;
//    private boolean isPlayerSurfaceClicked = false;
//    private boolean intLeft, intRight;
//    private int sWidth, sHeight;
//    private long diffX, diffY;
//    private Display display;
//    private Point size;
//    private float downX, downY;
//    int currBrightness;
//    int clickCount = 0;
//    long startTime1;
//    long duration;
//    static final int MAX_DURATION = 500;
//    private float upX1;
//    private float upX2;
//    private float upY1;
//    private float upY2;
//    public boolean isTouchCaptured = false;
//    static final int min_distance = 100;
//    public boolean isTapped;
//    private boolean isInternet;
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        showAllControls();
//    }
//
//    private final BroadcastReceiver networkReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent.getAction() != null && intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
//                NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK);
//                if (networkInfo != null)
//                    Log.d("internetCheck", "We have internet connection. Good to go." + networkInfo.getDetailedState());
//
//                if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
//                    //Log.d("internetCheck", "We have internet connection. Good to go.");
//                    if (viewModel != null) {
//                        viewModel.getPlayerObject().observe(DTPlayer.this, player -> {
//                            if (player != null) {
//                                if (isPlayerStart) {
//                                    if (!player.isPlaying()) {
//                                        playContentOnReconnect();
//                                    }
//
//                                }
//
//                            }
//                        });
//                    }
//
//                } else if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) {
//                    // Log.d("internetCheck", "We have lost internet connection");
//                    if (viewModel != null) {
//                        runningPlayer.pause();
//                        viewModel.getPlayerObject().observe(DTPlayer.this, player ->
//                                {
//
//                                }
//
//
//                        );
//                    }
//
//                }
//
//            }
//        }
//    };
//    private boolean drag = false;
//    private String defaultParentalRating = "";
//    private String userSelectedParentalRating = "";
//    private boolean assetKey = false;
//    private Map<String, Value> dvrMap;
//    private String values = "Today";
//    private Boolean isEnable = false;
//    private Boolean programCatchupEnable = false;
//    private List<RailCommonData> currentRailCommonData;
//    private List<RailCommonData> individualProgram;
//    private MyReceiver myReceiver;
//    private String month = "";
//    private String dd = "";
//    private String year = "";
//    private String hour = "";
//    private String minute = "";
//    private String time = "";
//    private boolean dvrEnabled = false;
//    private NetworkChangeReceiver receiver = null;
//    private IntentFilter filter;
//
//    private Animation animationFadeOut;
//    private Animation animationFadeIn;
//    private CountDownTimer cTimer = null;
//    private List<Asset> episodesList;
//    private Asset nextPlayingAsset;
//    private boolean isFirstAd = true;
//    private boolean hasEpisodesList = false;
//    private boolean isSeries = false;
//    private boolean hasNextEpisode = false;
//    private boolean playerChecksCompleted = false;
//    private int seasonNumber;
//    private int errorCode = -1;
//    private boolean isDialogShowing = false, isAudioTracks = false, isCaption = false;
//    private AudioManager mAudioManager;
//    private Boolean isLivePlayer = false;
//    private String jwt = "";
//    private int expiryDate;
//
//    private final BroadcastReceiver headsetRecicer = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
//                if (intent.getExtras() != null) {
//                    int headsetState = intent.getExtras().getInt("state");
//                    if (isPlayerStart && headsetState == 0) {
//                        pausePlayer();
//
//
//                    }
//                }
//            }
//        }
//    };
//    private int assetRuleErrorCode = -1;
//    @Override
//    public void onNetworkConnectionChanged(boolean isConnected) {
//        if (receiver != null) {
//            isInternet = isConnected;
//            if (isConnected) {
//            } else {
//                if (!DialogHelper.isIsDialog())
//                    if (runningPlayer != null) {
//                        runningPlayer.pause();
//                        getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//                        PrintLogging.printLog("onNetworkConnectionChanged", "onNetworkConnectionChanged");
//                    }
//                showNoInternetDialog();
//            }
//        }
//    }
//
//    private void showNoInternetDialog() {
//        try {
//            FragmentManager fm = getFragmentManager();
//            AlertDialogNetworkFragment alertDialog = AlertDialogNetworkFragment.newInstance(getResources().getString(R.string.no_internet_header), getResources().getString(R.string.no_internet_description), getResources().getString(R.string.try_again_small), getResources().getString(R.string.cancel));
//            alertDialog.setCancelable(false);
//            alertDialog.setAlertDialogCallBack(this);
//            if (fm != null)
//                alertDialog.show(fm, AppLevelConstants.TAG_FRAGMENT_ALERT);
//        } catch (IllegalStateException e) {
//
//        }
//    }
//
//    @Override
//    public void onFinishDialog(boolean status) {
//        if (status) {
//            getBinding().rl1.setVisibility(View.GONE);
//            hideVolumeDialog();
//            hideBrightnessDialog();
//            showPbar();
//            Handler mHandler = new Handler();
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (NetworkChangeReceiver.isOnline(getActivity())) {
//                        replayOnConnect();
//                    } else {
//                        if (Network.isMobileDataNetworkAvailable(getActivity()) || Network.checkConnectivityTypeMobile(getBaseActivity())) {
//                            replayOnConnect();
//                        } else {
//                            showNoInternetDialog();
//                        }
//                    }
//                }
//            }, 2000);
//
//
//        } else {
//            if (timer && timeHandler != null) {
//                timeHandler.removeCallbacks(myRunnable);
//            }
//            if (runningPlayer != null) {
//                PrintLogging.printLog(this.getClass(), "", "runningPlayer");
//                runningPlayer.stop();
//                runningPlayer.destroy();
//            }
//
//            if (viewModel != null)
//                viewModel.clearCallbacks();
//            baseActivity.onBackPressed();
//
//        }
//
//    }
//
//    private void replayOnConnect() {
//        getBinding().rl1.setVisibility(View.VISIBLE);
//        getBinding().pBar.setVisibility(View.GONE);
//        isInternet = true;
//        if (runningPlayer != null) {
//            if (isLivePlayer) {
//                getUrl(playerURL, playerAsset, playerProgress, true, programName1, railList, programAsset);
//            } else {
//                runningPlayer.play();
//                PrintLogging.printLog("replayOnConnect", "replayOnConnect");
//
//                getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//            }
//
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        baseActivity = (BaseActivity) context;
//    }
//
//    DisplayManager mDisplayManager;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        checkAutoRotation();
//        individualProgram = new ArrayList<>();
//        myReceiver = new MyReceiver();
//
//        powerManager = (PowerManager) baseActivity.getSystemService(POWER_SERVICE);
//        if (powerManager != null)
//            wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
//                    "MyApp::MyWakelockTag");
//
//
//        receiver = new NetworkChangeReceiver();
//        filter = new IntentFilter();
//        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//
//        mDisplayManager = (DisplayManager) baseActivity.getSystemService(Context.DISPLAY_SERVICE);
//        mDisplayManager.registerDisplayListener(mDisplayListener, null);
//        if (mDisplayManager != null) {
//            isHDMI(mDisplayManager);
//        }
//
//
//        getScreenSize();
//
//    }
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        try {
//            if (wakeLock != null) {
//                wakeLock.acquire();
//            }
//            TelephonyManager mgr = (TelephonyManager) baseActivity.getSystemService(TELEPHONY_SERVICE);
//            if (mgr != null) {
//                mgr.listen(PhoneStateListenerHelper.getInstance(this), PhoneStateListener.LISTEN_CALL_STATE);
//            }
//
//        } catch (Exception e) {
//            //   Log.e("TAG", e.getMessage());
//        }
//    }
//
//    @Override
//    public FragmentDtplayerBinding inflateBindingLayout(@NonNull LayoutInflater inflater) {
//        return FragmentDtplayerBinding.inflate(inflater);
//    }
//
//    private void modelCall() {
//        try {
//            viewModel = ViewModelProviders.of(this).get(DTPlayerViewModel.class);
//        } catch (IllegalStateException e) {
//
//        }
//    }
//
//    private Asset programAsset;
//
//    public void getUrl(String urlToplay, final Asset asset, int prog, Boolean isLivePlayer, String programName, List<RailCommonData> railCommonDataList, Asset programAsset) {
//        hasNextEpisode = false;
//        hasEpisodesList = false;
//        isPlayerStart = false;
//        playerAsset = asset;
//        playerURL = urlToplay;
//        this.programAsset = programAsset;
//        playerProgress = prog;
//        programName1 = programName;
//        this.asset = asset;
//        if (railCommonDataList != null)
//            this.railList = railCommonDataList;
//        setEventConvivaEvent(isLivePlayer, programAsset);
//
//        isSeries = (asset.getType() == MediaTypeConstant.getEpisode(getActivity()));
//        skipIntro();
//        getNextEpisode(asset);
//
//        if (isSeries) {
//            if (seasonNumber != 0 && episodeNumber != 0) {
//                getBinding().name.setText("S" + seasonNumber + ":E" + episodeNumber + " \"" + asset.getName() + "\"");
//            } else {
//                getBinding().name.setText("\"" + asset.getName() + "\"");
//            }
//        } else if (isLivePlayer) {
//            getBinding().name.setText("\"" + Constants.channelName + "\"");
//
//        } else {
//            getBinding().name.setText("\"" + asset.getName() + "\"");
//
//        }
//
//        this.isLivePlayer = isLivePlayer;
//        if (!this.isLivePlayer) {
//            showRlDown();
//            showSeekBar();
//            makeLiveTxtInvisible();
//            showPlayerMediaControls();
//
//
//        } else {
//            hideRlDown();
//            hideSeekBar();
//            showLiveTxt();
//            hidePlayerMediaControls();
//
//        }
//        checkAssetTypeCondition(urlToplay, asset, prog);
//
//    }
//
//    private void callWaterMarkApi() {
//        if (UserInfo.getInstance(baseActivity).isActive()) {
//            viewModel.callWaterMarkApi(KsPreferenceKey.getInstance(baseActivity).getKalturaPhoenixUrlForWaterMark(), KsPreferenceKey.getInstance(baseActivity).getStartSessionKs()).observe(this, new Observer<WaterMarkModel>() {
//                @Override
//                public void onChanged(WaterMarkModel waterMarkModel) {
//                    if (waterMarkModel != null) {
//                        if (waterMarkModel.getResponseCode() == 200) {
//                            jwt = waterMarkModel.getJwt();
//                            expiryDate = waterMarkModel.getExp();
//                        }
//                    }
//                }
//            });
//        }
//    }
//
//    private void setEventConvivaEvent(Boolean isLivePlayer, Asset programAsset) {
//        String fileId = "";
//        String duraton = AppCommonMethods.getDuration(asset);
//        fileId = AppCommonMethods.getFileIdOfAssest(playerAsset);
//        if (!isLivePlayer && !fileId.equalsIgnoreCase("")) {
//            new KsServices(baseActivity).getPlaybackContext(playerAsset.getId() + "", fileId, new PlayBackContextCallBack() {
//                @Override
//                public void getUrl(String url) {
//                    try {
//                        ConvivaManager.setreportPlaybackRequested(baseActivity, asset, duraton, isLivePlayer, url, programAsset);
//                    } catch (Exception ex) {
//                    }
//                }
//            });
//        } else {
//            try {
//                ConvivaManager.setreportPlaybackRequested(baseActivity, asset, duraton, isLivePlayer, "", programAsset);
//            } catch (Exception ex) {
//            }
//
//        }
//    }
//
//
//    private void checkAssetTypeCondition(String urlToplay, Asset asset, int prog) {
//        assetType = asset.getType();
//        modelCall();
//        hidePlayerControls();
//        UIControllers();
//        getAssetImage(asset, UDID.getDeviceId(requireContext(), requireContext().getContentResolver()));
//        startPhoenixInit();
//    }
//
//    private void getNextEpisode(Asset asset) {
//        checkSeasonAndEpisodeNumber(asset.getMetas());
//        if (viewModel == null) {
//            viewModel = ViewModelProviders.of(this).get(DTPlayerViewModel.class);
//        }
//        if (railList != null && railList.size() > 0) {
//            totalEpisode = railList.get(0).getTotalCount();
//            List<Asset> assets = new ArrayList<>();
//            RailCommonData railCommonData = new RailCommonData();
//            for (int i = 0; i < railList.size(); i++) {
//                railCommonData.setObject(railList.get(i).getObject());
//                assets.add(railCommonData.getObject());
//            }
//
//            episodesList = assets;
//            sortListWithEPSD(episodesList);
//        }
//    }
//
//    private void sortListWithEPSD(List<Asset> episodesList) {
//        try {
//            Handler mHandler = new Handler();
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    checkEpisode(episodesList);
//                }
//            }, 2000);
//
//        } catch (Exception e) {
//            PrintLogging.printLog(this.getClass(), "", "checkEpisode" + "checkEpisode");
//        }
//
//    }
//
//    private int nextEpisodeCounter = -1;
//
//    private void checkEpisode(List<Asset> episodesList) {
//        try {
//            boolean found = false;
//            hasEpisodesList = true;
//            if (episodesList.size() > 0) {
//                for (int i = 0; i < episodesList.size(); i++) {
//                    long listEpisode = episodesList.get(i).getId();
//                    if (asset.getId() == listEpisode) {
//                        found = true;
//                        if ((i + 1) <= totalEpisode)
//                            nextEpisodeCounter = i + 1;
//                        break;
//                    }
//                    //  }
//                }
//
//                if (found) {
//                    if ((nextEpisodeCounter != -1) && episodesList.size() > nextEpisodeCounter) {
//                        nextPlayingAsset = episodesList.get(nextEpisodeCounter);
//                        hasNextEpisode = true;
//                    } else {
//                        if (episodesList.size() < totalEpisode) {
//                            if (TabsData.getInstance().getSeriesType().equalsIgnoreCase(AppLevelConstants.OPEN)) {
//                                GetEpisodeListWithoutSeason();
//                            } else if (TabsData.getInstance().getSeriesType().equalsIgnoreCase(AppLevelConstants.CLOSE)) {
//                                seasonCounter = TabsData.getInstance().getSelectedSeason();
//                                getSeasonEpisode(seasonCounter, "");
//                            }
//                        } else {
//                            if (TabsData.getInstance().getSeriesType().equalsIgnoreCase(AppLevelConstants.CLOSE)) {
//                                seasonCounter++;
//                                TabsData.getInstance().setSelectedSeason(seasonCounter);
//                                episodeCounter = 1;
//                                nextEpisodeCounter = 0;
//                                railList.clear();
//                                episodesList.clear();
//                                seriesNumberList = TabsData.getInstance().getSeasonList();
//                                if (seriesNumberList.size() > seasonCounter && seriesNumberList.get(seasonCounter) != null)
//                                    getSeasonEpisode(seasonCounter, "nextSeason");
//
//                            }
//                        }
//                    }
//                }
//
//            }
//        } catch (Exception ex) {
//        }
//    }
//
//    private int episodeCounter = 2;
//    private int seasonCounter = 0;
//
//
//    private void GetEpisodeListWithoutSeason() {
//        if (TabsData.getInstance() != null && TabsData.getInstance().getSeriesAsset() != null) {
//            Asset seriesAsset = TabsData.getInstance().getSeriesAsset();
//
//            viewModel.callEpisodes(seriesAsset, seriesAsset.getType(), episodeCounter, 0, AppConstants.Rail5, TabsData.getInstance().getSortType()).observe(this, assetCommonBeans -> {
//                if (assetCommonBeans.get(0) != null && assetCommonBeans.get(0).getStatus() && assetCommonBeans.get(0).getRailAssetList() != null && assetCommonBeans.get(0).getRailAssetList().size() > 0) {
//                    episodeCounter++;
//                    for (RailCommonData railCommonData : assetCommonBeans.get(0).getRailAssetList()) {
//                        if (railCommonData.getObject() != null) {
//                            railList.add(railCommonData);
//                            episodesList.add(railCommonData.getObject());
//                        }
//                    }
//                    if (nextEpisodeCounter != -1 && episodesList.get(nextEpisodeCounter) != null) {
//                        nextPlayingAsset = episodesList.get(nextEpisodeCounter);
//                        hasNextEpisode = true;
//                    }
//                } else {
//                }
//
//            });
//        }
//    }
//
//    private List<Integer> seriesNumberList;
//
//    private void getSeasonEpisode(int seasonNumber, String nextSeason) {
//
//        Asset seriesAsset = TabsData.getInstance().getSeriesAsset();
//        if (!nextSeason.equalsIgnoreCase("")) {
//            viewModel.callSeasonEpisodes(seriesAsset, seriesAsset.getType(), episodeCounter, TabsData.getInstance().getSeasonList(), seasonNumber, AppConstants.Rail5, TabsData.getInstance().getSortType(), this).observe(this, assetCommonBeans -> {
//                if (assetCommonBeans.get(0) != null && assetCommonBeans.get(0).getStatus() && assetCommonBeans.get(0).getRailAssetList() != null && assetCommonBeans.get(0).getRailAssetList().size() > 0) {
//                    episodeCounter++;
//                    totalEpisode = assetCommonBeans.get(0).getTotalCount();
//                    for (RailCommonData railCommonData : assetCommonBeans.get(0).getRailAssetList()) {
//                        if (railCommonData.getObject() != null) {
//                            railList.add(railCommonData);
//                            episodesList.add(railCommonData.getObject());
//                        }
//                    }
//                    if (nextEpisodeCounter != -1 && episodesList.get(nextEpisodeCounter) != null) {
//                        nextPlayingAsset = episodesList.get(nextEpisodeCounter);
//                        hasNextEpisode = true;
//                    }
//                } else {
//
//                }
//
//            });
//        } else {
//            viewModel.callSeasonEpisodesBingeWatch(seriesAsset, seriesAsset.getType(), episodeCounter, TabsData.getInstance().getSeasonList(), seasonNumber, AppConstants.Rail5, TabsData.getInstance().getSortType()).observe(this, assetCommonBeans -> {
//                if (assetCommonBeans.get(0) != null && assetCommonBeans.get(0).getStatus() && assetCommonBeans.get(0).getRailAssetList() != null && assetCommonBeans.get(0).getRailAssetList().size() > 0) {
//                    episodeCounter++;
//                    totalEpisode = assetCommonBeans.get(0).getTotalCount();
//                    for (RailCommonData railCommonData : assetCommonBeans.get(0).getRailAssetList()) {
//                        if (railCommonData.getObject() != null) {
//                            railList.add(railCommonData);
//                            episodesList.add(railCommonData.getObject());
//                        }
//                    }
//                    if (nextEpisodeCounter != -1 && episodesList.get(nextEpisodeCounter) != null) {
//                        nextPlayingAsset = episodesList.get(nextEpisodeCounter);
//                        hasNextEpisode = true;
//                    }
//                } else {
//
//                }
//
//            });
//        }
//    }
//
//    private void playerChecks(final Asset asset) {
//        new GeoBlockingCheck().aseetAvailableOrNot(getActivity(), asset, (status, response, totalCount, errorcode, message) -> {
//            if (status) {
//                if (totalCount != 0) {
//                    playerChecksCompleted = true;
//                    checkBlockingErrors(response, asset);
//                } else {
//                    checkEntitleMent(asset);
//                }
//            } else {
//                showDialog(message);
//            }
//        });
//    }
//
//    private void checkErrors(Asset asset) {
//        try {
//            if (playerChecksCompleted) {
//                if (assetRuleErrorCode == AppLevelConstants.GEO_LOCATION_ERROR) {
//                    getActivity().runOnUiThread(() -> DialogHelper.openDialougeforGeoLocation(1, getActivity()));
//                } else if (errorCode == AppLevelConstants.FOR_PURCHASED_ERROR) {
//                    getActivity().runOnUiThread(() -> {
//                        FragmentManager fm = baseActivity.getSupportFragmentManager();
//                        EpisodeDialogFragment cancelDialogFragment = EpisodeDialogFragment.newInstance("player", AppCommonMethods.getFileIdOfAssest(asset));
//                        cancelDialogFragment.show(fm, AppLevelConstants.TAG_FRAGMENT_ALERT);
//                    });/* DialogHelper.openDialougeForEntitleMent(getActivity()));*/
//                } else if (errorCode == AppLevelConstants.USER_ACTIVE_ERROR) {
//                    getActivity().runOnUiThread(() -> DialogHelper.openDialougeForEntitleMent(getActivity()));
//                } else if (errorCode == AppLevelConstants.NO_MEDIA_FILE) {
//                    showDialog(getString(R.string.no_media_file));
//                } else if (errorCode == AppLevelConstants.NO_ERROR) {
//                    if (KsPreferenceKey.getInstance(getActivity()).getUserActive()) {
//                        parentalCheck(asset);
//                    } else {
//                        getUrl(AssetContent.getURL(asset), asset, playerProgress, isLivePlayer, "", railList, programAsset);
//                    }
//                } else {
//                    PrintLogging.printLog("", "elseValuePrint-->>" + assetRuleErrorCode + "  " + errorCode);
//                }
//            } else {
//                DialogHelper.showAlertDialog(getActivity(), getString(R.string.play_check_message), getString(R.string.ok), this);
//            }
//        } catch (Exception e) {
//
//        }
//    }
//
//
//    private void parentalCheck(Asset asset) {
//        if (KsPreferenceKey.getInstance(getActivity()).getUserActive()) {
//            if (KsPreferenceKey.getInstance(getActivity()).getParentalActive()) {
//                ResponseDmsModel responseDmsModel = AppCommonMethods.callpreference(getActivity());
//                defaultParentalRating = responseDmsModel.getParams().getDefaultParentalLevel();
//                userSelectedParentalRating = KsPreferenceKey.getInstance(getActivity()).getUserSelectedRating();
//                if (!userSelectedParentalRating.equalsIgnoreCase("")) {
//                    assetKey = AssetContent.getAssetKey(asset.getTags(), userSelectedParentalRating, getActivity());
//                    if (assetKey) {
//                        assetRuleErrorCode = AppLevelConstants.NO_ERROR;
//                        checkOnlyDevice(asset);
//                    } else {
//                        validateParentalPin(asset);
//                    }
//
//                } else {
//                    assetKey = AssetContent.getAssetKey(asset.getTags(), defaultParentalRating, getActivity());
//                    if (assetKey) {
//                        assetRuleErrorCode = AppLevelConstants.NO_ERROR;
//                        checkOnlyDevice(asset);
//                    } else {
//                        validateParentalPin(asset);
//                    }
//                }
//            } else {
//                getUrl(AssetContent.getURL(DTPlayer.asset), DTPlayer.asset, playerProgress, isLivePlayer, "", railList, programAsset);
//            }
//        }
//    }
//
//
//    private void validateParentalPin(Asset asset) {
//
//
//        new Handler(Looper.getMainLooper()).post(new Runnable() {
//            @Override
//            public void run() {
//                DialogHelper.showValidatePinDialog(getActivity(), null, AppLevelConstants.PLAYER, new ParentalDialogCallbacks() {
//                    @Override
//                    public void onPositiveClick(String pinText) {
//
//                        ParentalControlViewModel parentalViewModel = ViewModelProviders.of(getActivity()).get(ParentalControlViewModel.class);
//
//                        parentalViewModel.validatePin(getActivity(), pinText).observe(getActivity(), commonResponse -> {
//                            if (commonResponse.getStatus()) {
//                                DialogHelper.hideValidatePinDialog();
//                                assetRuleErrorCode = AppLevelConstants.NO_ERROR;
//                                // checkErrors(asset);
//                                checkOnlyDevice(asset);
//                            } else {
//                                Toast.makeText(getActivity(), getString(R.string.incorrect_parental_pin), Toast.LENGTH_LONG).show();
//                            }
//                        });
//
//                    }
//
//                    @Override
//                    public void onNegativeClick() {
//                        //  DialogHelper.hideValidatePinDialog();
//                        if (!((Activity) getActivity()).isFinishing()) {
//                            if (getActivity() != null) {
//                                getActivity().onBackPressed();
//                            }
//                        }
//                    }
//                });
//            }
//        });
//
//    }
//
//    private void checkOnlyDevice(Asset asset) {
//        new HouseHoldCheck().checkHouseholdDevice(getActivity(), commonResponse -> {
//            if (commonResponse != null) {
//
//                try {
//                    if (commonResponse.getStatus()) {
//                        //play next episode here
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//
//                                getUrl(AssetContent.getURL(asset), asset, playerProgress, isLivePlayer, "", railList, programAsset);
////                                if (isProgramClicked) {
////                                    if (checkIsliveAsset) {
////                                        getUrl(AssetContent.getURL(asset), asset, playerProgress, true, catchupLiveProgName, railList);
////                                    } else {
////                                        getUrl(AssetContent.getURL(catchupAsset), catchupAsset, playerProgress, false, asset.getName(), railList);
////                                    }
////                                } else {
////                                    getUrl(AssetContent.getURL(asset), asset, playerProgress, isLivePlayer, "", railList);
////                                }
//                            }
//                        });
//                    } else {
//                        if (commonResponse.getErrorCode().equals(AppLevelConstants.KS_EXPIRE)) {
//                            new RefreshKS(getActivity()).refreshKS(response -> checkDevice(asset));
//                        } else {
//                            showDialog(commonResponse.getMessage());
//                        }
//                    }
//                } catch (Exception e) {
//
//                }
//
//
//            }
//
//        });
//    }
//
//    private void checkDevice(final Asset asset) {
//        new HouseHoldCheck().checkHouseholdDevice(getActivity(), commonResponse -> {
//            if (commonResponse != null) {
//                if (commonResponse.getStatus()) {
//                    checkEntitleMent(asset);
//
//                } else {
//                    if (commonResponse.getErrorCode().equals(AppLevelConstants.KS_EXPIRE)) {
//                        new RefreshKS(getActivity()).refreshKS(response -> checkDevice(asset));
//                    } else {
//                        showDialog(commonResponse.getMessage());
//                    }
//                }
//            }
//
//        });
//
//    }
//
//    private void checkBlockingErrors(Response<ListResponse<UserAssetRule>> response, Asset asset) {
//        if (response != null && response.results != null && response.results.getObjects() != null) {
//            for (UserAssetRule userAssetRule :
//                    response.results.getObjects()) {
//                switch (userAssetRule.getRuleType()) {
//                    case GEO:
//                        playerChecksCompleted = true;
//                        assetRuleErrorCode = AppLevelConstants.GEO_LOCATION_ERROR;
//                        break;
////                    case PARENTAL:
////                        assetRuleErrorCode = AppLevelConstants.PARENTAL_BLOCK;
////                        checkEntitleMent(asset);
////                        break;
//                    default:
//                        checkEntitleMent(asset);
//                        break;
//                }
//            }
//        }
//    }
//
//    private void checkUserLoginCondition(Asset asset) {
//        checkEntitleMent(asset);
//    }
//
//    private void checkEntitleMent(final Asset asset) {
//        try {
//            String fileId = AppCommonMethods.getFileIdOfAssest(asset);
//            if (getActivity() != null) {
//                new EntitlementCheck().checkAssetPurchaseStatus(getActivity(), fileId, (apiStatus, purchasedStatus, vodType, purchaseKey, errorCode, message) -> {
//                    playerChecksCompleted = true;
//                    if (apiStatus) {
//                        if (purchasedStatus) {
//                            this.errorCode = AppLevelConstants.NO_ERROR;
//                        } else {
//                            if (vodType.equalsIgnoreCase(EntitlementCheck.SVOD)) {
//                                this.errorCode = AppLevelConstants.FOR_PURCHASED_ERROR;
//                            } else if (vodType.equalsIgnoreCase(EntitlementCheck.TVOD)) {
//                                this.errorCode = AppLevelConstants.FOR_PURCHASED_ERROR;
//                            }
//                        }
//                    } else {
//
//                    }
//                });
//              /*  new EntitlementCheck().checkAssetType(getActivity(), fileId, (status, response, purchaseKey, errorCode1, message) -> {
//                    if (status) {
//                        playerChecksCompleted = true;
//                        if (purchaseKey.equalsIgnoreCase(getResources().getString(R.string.FOR_PURCHASE_SUBSCRIPTION_ONLY)) || purchaseKey.equals(getResources().getString(R.string.FREE))) {
//                            errorCode = AppLevelConstants.NO_ERROR;
//                        } else if (purchaseKey.equals(getResources().getString(R.string.FOR_PURCHASED))) {
//                            if (KsPreferenceKey.getInstance(getActivity()).getUserActive()) {
//                                isDtvAccountAdded(asset);
//                                //check Dtv Account Added or Not
//
//                            } else {
//                                errorCode = AppLevelConstants.FOR_PURCHASED_ERROR;
//
//                            }
//                        } else {
//                            if (KsPreferenceKey.getInstance(getActivity()).getUserActive()) {
//                                isDtvAccountAdded(asset);
//                                //check Dtv Account Added or Not
//                            } else {
//                                errorCode = AppLevelConstants.USER_ACTIVE_ERROR;
//                                //not play
//                            }
//
//
//                        }
//                    } else {
//                        if (message != "")
//                            showDialog(message);
//                    }
////                                    playerChecksCompleted = true;
//                });
//           */
//            }
//        } catch (Exception e) {
//
//        }
//    }
//
//    private void isDtvAccountAdded(Asset asset) {
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                viewModel.getDtvAccountList().observe(getActivity(), new Observer<String>() {
//                    @Override
//                    public void onChanged(String dtvAccount) {
//                        try {
//                            if (dtvAccount != null) {
//                                if (dtvAccount.equalsIgnoreCase("0")) {
//                                    isDtvAdded = false;
//                                    checkForSubscription(isDtvAdded, asset);
//
//                                } else if (dtvAccount.equalsIgnoreCase("")) {
//                                    isDtvAdded = false;
//                                    checkForSubscription(isDtvAdded, asset);
//
//                                } else {
//                                    isDtvAdded = true;
//                                    checkForSubscription(isDtvAdded, asset);
//
//                                }
//
//                            } else {
//                                // Api Failure Error
//
//                                showDialog(getString(R.string.something_went_wrong_try_again));
//                            }
//                        } catch (Exception e) {
//                            Log.e("ExceptionIs", e.toString());
//                        }
//                    }
//                });
//
//            }
//        });
//
//    }
//
//    private void checkForSubscription(boolean isDtvAdded, Asset asset) {
//        //***** Mobile + Non-Dialog + Non-DTV *************//
//        if (KsPreferenceKey.getInstance(getActivity()).getUserType().equalsIgnoreCase(AppLevelConstants.NON_DIALOG) && isDtvAdded == false) {
//            getActivity().runOnUiThread(() -> DialogHelper.openDialougeFornonDialog(getActivity(), isLiveChannel));
//            getActivity().finish();
//        }
//        //********** Mobile + Non-Dialog + DTV ******************//
//        else if (KsPreferenceKey.getInstance(getActivity()).getUserType().equalsIgnoreCase(AppLevelConstants.NON_DIALOG) && isDtvAdded == true) {
//            getActivity().runOnUiThread(() -> DialogHelper.openDialougeFornonDialog(getActivity(), isLiveChannel));
//            getActivity().finish();
//        }
//        //*********** Mobile + Dialog + Non-DTV *****************//
//        else if (KsPreferenceKey.getInstance(getActivity()).getUserType().equalsIgnoreCase(AppLevelConstants.DIALOG) && isDtvAdded == false) {
//            if (AssetContent.isPurchaseAllowed(asset.getMetas(), asset, getActivity())) {
//                getActivity().runOnUiThread(() -> DialogHelper.openDialougeForDtvAccount(getActivity(), true, isLiveChannel));
//                getActivity().finish();
//            } else {
//                getActivity().runOnUiThread(() -> DialogHelper.openDialougeForDtvAccount(getActivity(), false, isLiveChannel));
//                getActivity().finish();
//            }
//        }
//        //************ Mobile + Dialog + DTV ********************//
//        else if (KsPreferenceKey.getInstance(getActivity()).getUserType().equalsIgnoreCase(AppLevelConstants.DIALOG) && isDtvAdded == true) {
//            if (AssetContent.isPurchaseAllowed(asset.getMetas(), asset, getActivity())) {
//                getActivity().runOnUiThread(() -> DialogHelper.openDialougeForDtvAccount(getActivity(), true, isLiveChannel));
//                getActivity().finish();
//            } else {
//                getActivity().runOnUiThread(() -> DialogHelper.openDialougeForDtvAccount(getActivity(), false, isLiveChannel));
//                getActivity().finish();
//            }
//        } else {
//            showDialog(getString(R.string.something_went_wrong_try_again));
//            getActivity().finish();
//        }
//    }
//
//    private void hidePlayerControls() {
//        getBinding().rl1.setVisibility(View.VISIBLE);
//        getBinding().playButton.setVisibility(View.GONE);
//        hideSeekBar();
//        hideCurrentTime();
//        hideTotalDuration();
//        hideFullscreen();
//        getBinding().forward.setVisibility(View.GONE);
//        getBinding().backward.setVisibility(View.GONE);
//        showPbar();
//        getBinding().playericon.setVisibility(View.GONE);
//        // getBinding().ivQuality.setVisibility(View.GONE);
//        getBinding().ivCancel.setVisibility(View.GONE);
//        getBinding().loading.setVisibility(View.VISIBLE);
//        getBinding().linearAutoPlayLayout.setVisibility(View.GONE);
//        getBinding().slash.setVisibility(View.GONE);
//        getBinding().subtitleAudio.setVisibility(View.GONE);
//        getBinding().quality.setVisibility(View.GONE);
//        hideVolumeDialog();
//        hideBrightnessDialog();
//        //  getBinding().shareWith.setVisibility(View.GONE);
//
//    }
//
//    private void playContent() {
//        callHandler();
//        if (lockEnable) {
//
//        } else {
//            try {
//                getBinding().rl1.setVisibility(View.VISIBLE);
//                getBinding().playButton.setVisibility(View.VISIBLE);
//                getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//                //  getBinding().seekBar.setVisibility(View.VISIBLE);
//                getBinding().currentTime.setVisibility(View.VISIBLE);
//                getBinding().totalDuration.setVisibility(View.VISIBLE);
//                getBinding().fullscreen.setVisibility(View.GONE);
//                getBinding().forward.setVisibility(View.VISIBLE);
//                getBinding().backward.setVisibility(View.GONE);
//                //   getBinding().ivQuality.setVisibility(View.VISIBLE);
//                getBinding().name.setVisibility(View.VISIBLE);
//                getBinding().ivCancel.setVisibility(View.VISIBLE);
//                getBinding().slash.setVisibility(View.VISIBLE);
//                getBinding().quality.setVisibility(View.VISIBLE);
//                // getBinding().shareWith.setVisibility(View.VISIBLE);
//            } catch (Exception e) {
//                // Log.e("Exception",e.getMessage());
//            }
//        }
//        getBinding().rl.setVisibility(View.VISIBLE);
//        getBinding().playericon.setVisibility(View.GONE);
//        hidePbar();
//
//        if (dvrEnabled) {
//            getBinding().goLive.setVisibility(View.VISIBLE);
//            showSeekBar();
//        } else {
//            getBinding().goLive.setVisibility(View.GONE);
//
//            //Write code here to check content is Program or not
//
//            if (!isLivePlayer) {
//
//                if (isSeries && episodesList != null && episodesList.size() > 0) {
//                    getBinding().nextEpisode.setVisibility(View.VISIBLE);
//                } else {
//                    getBinding().nextEpisode.setVisibility(View.GONE);
//                }
//                showSeekBar();
//
////                if (KsPreferenceKey.getInstance(getActivity()).getCatchupValue()) {
////                    getBinding().arrowBack.setVisibility(View.VISIBLE);
////                    getBinding().arrowForward.setVisibility(View.VISIBLE);
////                    getBinding().playCatchup.setVisibility(View.VISIBLE);
////                    getBinding().currentTime.setVisibility(View.VISIBLE);
////                    getBinding().totalDuration.setVisibility(View.VISIBLE);
////                    getBinding().ivCancel.setVisibility(View.VISIBLE);
////                    getBinding().slash.setVisibility(View.VISIBLE);
////                    getBinding().quality.setVisibility(View.VISIBLE);
////                }
//
//            } else {
//                hideSeekBar();
//                getBinding().quality.setVisibility(View.GONE);
//
//            }
//
//        }
//
////        if (isLivePlayer && isEnable && dvrEnabled) {
////            getBinding().arrowBack.setVisibility(View.VISIBLE);
////            getBinding().arrowForward.setVisibility(View.VISIBLE);
////            getBinding().playCatchup.setVisibility(View.VISIBLE);
////
////        } else if (isLivePlayer && isEnable) {
////            getBinding().arrowBack.setVisibility(View.VISIBLE);
////            getBinding().arrowForward.setVisibility(View.VISIBLE);
////            getBinding().playCatchup.setVisibility(View.INVISIBLE);
////        } else if (isLivePlayer && dvrEnabled) {
////            getBinding().arrowBack.setVisibility(View.VISIBLE);
////            getBinding().arrowForward.setVisibility(View.VISIBLE);
////            getBinding().playCatchup.setVisibility(View.VISIBLE);
////        }
//
//
//        getBinding().loading.setVisibility(View.GONE);
//        isPurchased = 1;
//        getBinding().linearAutoPlayLayout.setVisibility(View.GONE);
//        //   getBinding().lockIcon.setVisibility(View.VISIBLE);
//        showRlUp();
//
//
//        if (!isLivePlayer)
//            showRlDown();
//
//    }
//
//
//    //Performing Single and Double Tap on Forward and Backward Icon
//
//
//    private void openShareDialouge() {
//        AppCommonMethods.openShareDialog(getActivity(), asset, getActivity(), "");
//    }
//
//
//    private void hideCatchupControls() {
//        getBinding().rl1.setVisibility(View.GONE);
////        getBinding().arrowBack.setVisibility(View.GONE);
////        getBinding().arrowForward.setVisibility(View.GONE);
//        hideCurrentTime();
//        getBinding().totalDuration.setVisibility(View.GONE);
////        getBinding().playCatchup.setVisibility(View.GONE);
//        getBinding().goLive.setVisibility(View.GONE);
//        hideSeekBar();
//        getBinding().slash.setVisibility(View.GONE);
//        getBinding().subtitleAudio.setVisibility(View.GONE);
//        getBinding().quality.setVisibility(View.GONE);
//    }
//
//    private void unHideCatchupControls() {
//        getBinding().rl1.setVisibility(View.GONE);
////        getBinding().arrowBack.setVisibility(View.GONE);
////        getBinding().arrowForward.setVisibility(View.GONE);
//        hideCurrentTime();
//        hideTotalDuration();
//        // getBinding().playCatchup.setVisibility(View.GONE);
//        getBinding().goLive.setVisibility(View.GONE);
//        hideSeekBar();
//        getBinding().slash.setVisibility(View.GONE);
//        getBinding().subtitleAudio.setVisibility(View.GONE);
//        getBinding().quality.setVisibility(View.GONE);
//    }
//
//
//    private void getSpecificAsset(Asset object) {
//
//        if (object.getType() == MediaTypeConstant.getProgram(getActivity())) {
//            ProgramAsset progAsset = (ProgramAsset) object;
//            catchupAsset = object;
//
//
//            PrintLogging.printLog(this.getClass(), "", "programAssetId" + progAsset.getLinearAssetId());
//            viewModel.getSpecificAsset(progAsset.getLinearAssetId().toString()).observe(this, railCommonData -> {
//                if (railCommonData != null && railCommonData.getStatus()) {
//
//
//                    Handler mHandler = new Handler();
//                    mHandler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            getBinding().pBar.setVisibility(View.GONE);
//                            checkErrors(railCommonData.getObject());
//                        }
//                    }, 3000);
//                    playerChecks(railCommonData.getObject());
//
//
//                }
//            });
//        }
//    }
//
//
//    private String checkDigit(int number) {
//        return number <= 9 ? "0" + number : String.valueOf(number);
//    }
//
//
//    private String getDateTimeStamp(Long timeStamp) {
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm a", Locale.US);
//        return formatter.format(timeStamp);
//    }
//
//    private void startPhoenixInit() {
//
//        map = asset.getTags();
//
//        OnMediaLoadCompletion playLoadedEntry = response -> {
//            if (baseActivity != null) {
//                baseActivity.runOnUiThread(() -> {
//                    if (response != null) {
//                        if (response.isSuccess()) {
//                            onMediaLoaded(response.getResponse());
//                        } else {
//                            try {
//                                ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportPlaybackFailed(response.getError().toString());
//                            } catch (Exception ex) {
//                            }
//                            /*handling 601 error code for session token expire*/
//                            isError = true;
//                            if (response.getError().getCode().equalsIgnoreCase("601")) {
//                                DialogHelper.showLoginDialog(getActivity());
//                            } else {
//                                if (baseActivity != null && !baseActivity.isFinishing()) {
//                                    if (response.getError().getCode().equalsIgnoreCase(AppLevelConstants.KS_EXPIRE)) {
//                                        new RefreshKS(baseActivity).refreshKS(new RefreshTokenCallBack() {
//                                            @Override
//                                            public void response(CommonResponse response) {
//                                                if (baseActivity != null && !baseActivity.isFinishing()) {
//                                                    baseActivity.runOnUiThread(new Runnable() {
//                                                        @Override
//                                                        public void run() {
//                                                            if (runningPlayer != null) {
//                                                                runningPlayer.destroy();
//                                                                if (PlayerRepository.getInstance() != null) {
//                                                                    PlayerRepository.getInstance().destroCallBacks();
//                                                                }
//                                                            }
//                                                            baseActivity.onBackPressed();
//                                                        }
//                                                    });
//                                                }
//
//
//                                            }
//                                        });
//                                    } else if (response.getError().getCode().equalsIgnoreCase(AppLevelConstants.LOGGED_OUT_ERROR_CODE) || response.getError().getCode().equalsIgnoreCase(AppLevelConstants.DEVICE_EXIST_ERROR_CODE) || response.getError().getCode().equalsIgnoreCase(AppLevelConstants.DEVICE_NOT_IN_DOMAIN)) {
//                                        openHouseHoldDialog(baseActivity);
//                                    } else {
//                                        showDialog(new ErrorCallBack().ErrorMessage(response.getError().getCode(), response.getError().getMessage()));
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                });
//            }
//
//        };
//        startOttMediaLoadingProd(playLoadedEntry, asset);
//    }
//
//    public void openHouseHoldDialog(final Activity context) {
//        BaseActivity baseActivity = (BaseActivity) context;
//        FragmentManager fm = baseActivity.getSupportFragmentManager();
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AppAlertTheme);
//        builder.setTitle(context.getResources().getString(R.string.device_Removed)).setMessage(context.getResources().getString(R.string.device_removed_description))
//                .setCancelable(true)
//                .setPositiveButton(context.getResources().getString(R.string.continue_as_guest), (dialog, id) -> {
//                    logoutApi();
//                    AppCommonMethods.removeUserPrerences(baseActivity);
//                    new ActivityLauncher(context).homeScreen(context, HomeActivity.class);
//                    dialog.cancel();
//                })
//                .setNegativeButton(context.getResources().getString(R.string.login), (dialog, id) -> {
//                    logoutApi();
//                    AppCommonMethods.removeUserPrerences(baseActivity);
//                    UserInfo.getInstance(baseActivity).setHouseHoldError(true);
//                    new ActivityLauncher(context).homeScreen(context, HomeActivity.class);
//                    dialog.cancel();
//                });
//
//        AlertDialog alert = builder.create();
//        alert.show();
//        Button bn = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
//        bn.setTextColor(ContextCompat.getColor(context, R.color.aqua_marine));
//        Button bp = alert.getButton(DialogInterface.BUTTON_POSITIVE);
//        bp.setTextColor(ContextCompat.getColor(context, R.color.aqua_marine));
//
//    }
//
//    private void logoutApi() {
//        viewModel.logoutUser(UserInfo.getInstance(getActivity()).getAccessToken(), UserInfo.getInstance(getActivity()).getExternalSessionToken()).observe(this, logoutExternalResponseEvergentCommonResponse -> {
//
//        });
//    }
//
//    private void loggedOutMessage() {
//        try {
//            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(baseActivity, R.style.AppAlertTheme);
//            builder.setTitle(baseActivity.getResources().getString(R.string.dialog));
//            builder.setMessage(baseActivity.getResources().getString(R.string.logged_out_message))
//                    .setCancelable(true)
//                    .setPositiveButton("Ok", (dialog, id) -> {
//                        KsPreferenceKey.getInstance(baseActivity).setUserActive(false);
//                        KsPreferenceKey.getInstance(baseActivity).setUserActive(false);
//                        KsPreferenceKey.getInstance(baseActivity).setUser(null);
//                        KsPreferenceKey.getInstance(baseActivity).setStartSessionKs("");
//                        KsPreferenceKey.getInstance(baseActivity).setMsisdn("");
//                        KsPreferenceKey.getInstance(baseActivity).setUserSelectedRating("");
//                        KsPreferenceKey.getInstance(baseActivity).setParentalActive(false);
//                        KsPreferenceKey.getInstance(baseActivity).setUserType("");
//                        new ActivityLauncher(baseActivity).homeScreen(baseActivity, HomeActivity.class);
//
//                    });
//
//            android.app.AlertDialog alert = builder.create();
//            alert.show();
//            alert.setCancelable(false);
//            Button bn = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
//            bn.setTextColor(ContextCompat.getColor(baseActivity, R.color.blue));
//            Button bp = alert.getButton(DialogInterface.BUTTON_POSITIVE);
//            bp.setTextColor(ContextCompat.getColor(baseActivity, R.color.colorPrimary));
//        } catch (Exception ignored) {
//
//        }
//    }
//
//    private void startOttMediaLoadingProd(final OnMediaLoadCompletion completion, Asset asset) {
//        SessionProvider ksSessionProvider = new SessionProvider() {
//            @Override
//            public String baseUrl() {
//
//                if (BuildConfig.FLAVOR.equalsIgnoreCase("prod")) {
//                    Log.d("LoadedUrlIs", "PROD");
//                    return KsPreferenceKey.getInstance(baseActivity).getKalturaPhoenixUrl();
//                } else {
//                    Log.d("LoadedUrlIs", "QA");
//                    return "https://rest-sgs1.ott.kaltura.com/api_v3/";
//                }
//
//
//            }
//
//            @Override
//            public void getSessionToken(OnCompletion<PrimitiveResult> completion) {
//                String ks1 = "";
//                if (UserInfo.getInstance(baseActivity).isActive()) {
//                    ks1 = KsPreferenceKey.getInstance(baseActivity).getStartSessionKs();
//
//                    if (ks1.isEmpty()) {
//                        ks1 = KsPreferenceKey.getInstance(baseActivity).getAnonymousks();
//
//                    }
//                } else {
//                    ks1 = KsPreferenceKey.getInstance(baseActivity).getAnonymousks();
//
//                }
//
//                if (completion != null) {
//                    completion.onComplete(new PrimitiveResult(ks1));
//                }
//            }
//
//            @Override
//            public int partnerId() {
//                return AppLevelConstants.PARTNER_ID;
//            }
//        };
//
//        new KsServices(baseActivity).callBookMarking(asset, position -> {
//            if (assetType == MediaTypeConstant.getProgram(baseActivity)) {
//                assetPosition = 0;
//            } else {
//                assetPosition = position;
//            }
//
//        });
//
//        String mediaId = asset.getId().toString();
//        AssetContent.getVideoResolution(asset.getTags()).observe(this, videoResolution -> {
//            String format = "";
//            if (AppCommonMethods.callpreference(baseActivity) != null && AppCommonMethods.callpreference(baseActivity).getParams() != null && AppCommonMethods.callpreference(baseActivity).getParams().getFilesFormat() != null && AppCommonMethods.callpreference(baseActivity).getParams().getFilesFormat().getDASHWV() != null) {
//                format = AppCommonMethods.callpreference(baseActivity).getParams().getFilesFormat().getDASHWV();
//            } else {
//                format = AppLevelConstants.DASH_WIDEVINE;
//            }
//            MediaEntryProvider mediaProvider;
//            if (asset.getType() == MediaTypeConstant.getLinear(baseActivity)) {
//                if (!isLivePlayer) {
//                    mediaProvider = new PhoenixMediaProvider()
//                            .setSessionProvider(ksSessionProvider)
//                            .setAssetId(mediaId)
//                            .setProtocol(PhoenixMediaProvider.HttpProtocol.Https)
//                            .setContextType(APIDefines.PlaybackContextType.Catchup)
//                            .setAssetType(APIDefines.KalturaAssetType.Epg)
//                            .setFormats(format);
//                    mediaProvider.load(completion);
//                } else {
//                    mediaProvider = new PhoenixMediaProvider()
//                            .setSessionProvider(ksSessionProvider)
//                            .setAssetId(mediaId)
//                            .setProtocol(PhoenixMediaProvider.HttpProtocol.Https)
//                            .setContextType(APIDefines.PlaybackContextType.Playback)
//                            .setAssetType(APIDefines.KalturaAssetType.Media)
//                            .setFormats(format);
//                    mediaProvider.load(completion);
//                }
//            } else if (asset.getType() == MediaTypeConstant.getProgram(baseActivity)) {
//                mediaProvider = new PhoenixMediaProvider()
//                        .setSessionProvider(ksSessionProvider)
//                        .setAssetId(mediaId)
//                        .setProtocol(PhoenixMediaProvider.HttpProtocol.Https)
//                        .setContextType(APIDefines.PlaybackContextType.Catchup)
//                        .setAssetType(APIDefines.KalturaAssetType.Epg)
//                        .setFormats(format);
//                mediaProvider.load(completion);
//
//            } else {
//                mediaProvider = new PhoenixMediaProvider()
//                        .setSessionProvider(ksSessionProvider)
//                        .setAssetId(mediaId)
//                        .setProtocol(PhoenixMediaProvider.HttpProtocol.Https)
//                        .setContextType(APIDefines.PlaybackContextType.Playback)
//                        .setAssetType(APIDefines.KalturaAssetType.Media)
//                        .setFormats(format);
//                mediaProvider.load(completion);
//            }
//
//
//        });
//
//    }
//
//    private void onMediaLoaded(PKMediaEntry mediaEntry) {
//        try {
//            if (playerAsset.getType() == MediaTypeConstant.getLinear(getActivity())) {
//                mediaEntry.setMediaType(PKMediaEntry.MediaEntryType.Live);
//            } else {
//                mediaEntry.setMediaType(PKMediaEntry.MediaEntryType.Vod);
//
//            }
//
//
//            if (getActivity() != null && getActivity().getSystemService(Context.AUDIO_SERVICE) != null) {
//                mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
//            }
//
//            int result = mAudioManager.requestAudioFocus(this,
//                    // Use the music stream.
//                    AudioManager.STREAM_MUSIC,
//                    // Request permanent focus.
//                    AudioManager.AUDIOFOCUS_GAIN);
//
//            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                if (isLivePlayer) {
//                    if (UserInfo.getInstance(baseActivity).isActive()) {
//                        if (AppCommonMethods.isTokenExpired(baseActivity)) {
//                            viewModel.callWaterMarkApi(KsPreferenceKey.getInstance(baseActivity).getKalturaPhoenixUrlForWaterMark(), KsPreferenceKey.getInstance(baseActivity).getStartSessionKs()).observe(this, new Observer<WaterMarkModel>() {
//                                @Override
//                                public void onChanged(WaterMarkModel waterMarkModel) {
//                                    if (waterMarkModel != null) {
//                                        if (waterMarkModel.getResponseCode() == 200) {
//                                            jwt = waterMarkModel.getJwt();
//                                            expiryDate = waterMarkModel.getExp();
//                                            KsPreferenceKey.getInstance(baseActivity).setExpiryTime(expiryDate);
//                                            KsPreferenceKey.getInstance(baseActivity).setJwtToken(jwt);
//                                            startPlayer(mediaEntry);
//                                        } else {
//                                            if (waterMarkModel.getResponseCode() == 500016) {
//                                                new RefreshKS(baseActivity).refreshKS(new RefreshTokenCallBack() {
//                                                    @Override
//                                                    public void response(CommonResponse ksresponse) {
//                                                        playBackError();
//                                                    }
//                                                });
//                                            } else {
//                                                playBackError();
//                                            }
//                                        }
//                                    } else {
//                                        playBackError();
//                                    }
//                                }
//                            });
//                        } else {
//                            startPlayer(mediaEntry);
//                        }
//                    } else {
//                        startPlayer(mediaEntry);
//                    }
//                } else {
//                    startPlayer(mediaEntry);
//                }
//            }
//
//            AsyncTask.execute(new Runnable() {
//                @Override
//                public void run() {
//
//
//                    if (isLivePlayer) {
//                    } else {
//                        // Run whatever background code you want here.
//                        if (!isEnable) {
//                            if (BuildConfig.FLAVOR.equalsIgnoreCase("qa")) {
//
//                                String EntryId = AssetContent.getMediaEntryId(mediaEntry.getMetadata());
//                                if (!EntryId.equalsIgnoreCase("")) {
//                                    scrubberUrl = "https://cdnapi.kaltura.com" + "/p/3089623" + "/sp/308962300/thumbnail/entry_id/" + EntryId + "/width/150/vid_slices/100";
//                                    new ImageLoadTask(scrubberUrl, getBinding().imagePreview).execute();
//                                }
//                            } else {
//                                String EntryId = AssetContent.getMediaEntryId(mediaEntry.getMetadata());
//                                if (!EntryId.equalsIgnoreCase("")) {
//                                    scrubberUrl = "https://cdnapi.kaltura.com" + "/p/3089633" + "/sp/308963300/thumbnail/entry_id/" + EntryId + "/width/150/vid_slices/100";
//                                    new ImageLoadTask(scrubberUrl, getBinding().imagePreview).execute();
//                                }
//                            }
//                        }
//
//                    }
//                }
//            });
//
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    private void getPlayerState() {
//        runningPlayer.addListener(this, PlayerEvent.Type.STATE_CHANGED, event -> {
//            PlayerEvent.StateChanged stateChanged = (PlayerEvent.StateChanged) event;
//            switch (stateChanged.newState) {
//                case IDLE:
//                    Log.d("StateChange ", "IDLE");
//
//                    //  log.d("StateChange Idle");
//                    break;
//                case LOADING:
//                    Log.d("StateChange ", "LOADING");
//
//                    //  log.d("StateChange Loading");
//                    break;
//                case READY:
//                    hidePbar();
//
//                    Log.d("StateChange ", "Ready");
//                    break;
//                case BUFFERING:
//                    Log.d("StateChange ", "Buffering");
//                    if (!isAdsRunning) {
//                        showPbar();
//                        try {
//                            ConvivaManager.convivaPlayerBufferReportRequest();
//                        } catch (Exception ex) {
//                        }
//                    } else {
//
//                    }
//                    break;
//            }
//
//        });
//    }
//
//    private void startPlayer(PKMediaEntry mediaEntry) {
//
//        Log.e("DTPlayer", "DTPlayer assetPosition" + assetPosition);
//        try {
//            viewModel.startPlayerBookmarking(mediaEntry, UDID.getDeviceId(baseActivity, baseActivity.getContentResolver()), asset, isPurchased, assetPosition, jwt, isLivePlayer).observe(this, player -> {
//                if (player != null) {
//                    adsCallBackHandling(player);
//                    getPlayerView(player);
//                    player.getSettings().setSurfaceAspectRatioResizeMode(PKAspectRatioResizeMode.fit);
//                    getPlayerState();
//
//                }
//            });
//        } catch (Exception e) {
//            PrintLogging.printLog("Exception", e.toString());
//        }
//
//    }
//
//    private void haveAudioOrNot() {
//        viewModel.loadAudioWithPlayer().observe(this, audioTracks -> {
//            Log.w("audioAndSubtitle", "in3");
//            if (audioTracks != null && audioTracks.size() > 0) {
//                Log.w("audioAndSubtitle", "in4");
//                viewModel.getAudioTrackItems().observe(baseActivity, trackItems -> {
//                    Log.w("audioAndSubtitle", "in5");
//                    if (trackItems.length > 0) {
//                        Log.w("audioAndSubtitle", "in6");
//                        Log.w("audioAndSubtitle", trackItems + "   " + audioTracks.get(0).getLabel());
//                        if (trackItems[0].getTrackName() != null && !trackItems[0].getTrackName().equalsIgnoreCase("")) {
//                            isAudioTracks = true;
//                            audioList = trackItems.clone();
//
//                        } else {
//                            isAudioTracks = false;
//                            audioList = null;
//
//                        }
//
//                    } else {
//                        isAudioTracks = false;
//                        Log.w("audioAndSubtitle", "in7");
//                    }
//
//                });
//
//
//            } else {
//                isAudioTracks = false;
//            }
//
//        });
//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (isCaption || isAudioTracks) {
//                    getBinding().subtitleAudio.setVisibility(View.VISIBLE);
//                } else {
//                    getBinding().subtitleAudio.setVisibility(View.GONE);
//                }
//            }
//        }, 2000);
//
//
//    }
//
//    public void showAdsView() {
//        adRunning = true;
//        getBinding().rl1.setVisibility(View.GONE);
//        getBinding().loading.setVisibility(View.GONE);
//        getBinding().pBar.setVisibility(View.GONE);
//
//
//    }
//
//    private long introStartTime;
//    private int skipValue = 0;
//    private long introEndTime;
//    private long creditEndTime = 0;
//    private String labelIntro;
//    private String labelCredit;
//    private String labelRecap;
//    private long creditStartTime = 0;
//    private long recapStartTime;
//    private long recapEndTime;
//
//
//    private void skipIntro() {
//        labelIntro = "Skip Intro";
//        labelCredit = "Skip Credit";
//        labelRecap = "Skip Recap";
//        introStartTime = AssetContent.getIntroStart(playerAsset.getMetas());
//        introEndTime = AssetContent.getIntroEnd(playerAsset.getMetas());
//        creditStartTime = AssetContent.getCreditStart(playerAsset.getMetas());
//        creditEndTime = AssetContent.getCreditEnd(playerAsset.getMetas());
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                recapStartTime = AssetContent.getRecapStart(playerAsset.getMetas());
//                recapEndTime = AssetContent.getRecapEnd(playerAsset.getMetas());
//                Log.w("introValues", introStartTime + "  " + introEndTime + "  " + creditStartTime + "  " + creditEndTime + " " + recapStartTime + " " + recapEndTime);
//            }
//        }, 5000);
//
//
//    }
//
//    private long playerTimeInSeconds(long timeMs) {
//        long totalSeconds = (timeMs) / 1000;
//        return totalSeconds;
//    }
//
//    private void adsCallBackHandling(final Player player) {
//
//        player.addListener(this, AdEvent.started, event -> {
//            //Some events holds additional data objects in them.
//            //In order to get access to this object you need first cast event to
//            //the object it belongs to. You can learn more about this kind of objects in
//            //our documentation.
//            //  ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric("ADS STARTED");
//
//            if (isFirstAd) {
//                new Handler().postDelayed(() -> {
//                    haveAudioOrNot();
//                    haveSubtitleorNot();
//
//                }, 7000);
//                isFirstAd = false;
//            }
//            AdEvent.AdStartedEvent adStartedEvent = event;
//
//            //Then you can use the data object itself.
//            AdInfo adInfo = adStartedEvent.adInfo;
//            //Print to log content type of this ad.
//            showAdsView();
//            Log.d(TAG, "ad event received: " + event.eventType().name()
//                    + ". Additional info: ad content type is: "
//                    + adInfo.getAdContentType());
//        });
//
//        player.addListener(this, AdEvent.contentResumeRequested, event -> {
//            Log.d(TAG, "ADS_PLAYBACK_ENDED");
//        });
//
//        player.addListener(this, AdEvent.adPlaybackInfoUpdated, event -> {
//            AdEvent.AdPlaybackInfoUpdated playbackInfoUpdated = event;
//            Log.d(TAG, "AD_PLAYBACK_INFO_UPDATED  = " + playbackInfoUpdated.width + "/" + playbackInfoUpdated.height + "/" + playbackInfoUpdated.bitrate);
//        });
//
//        player.addListener(this, AdEvent.skippableStateChanged, event -> {
//            Log.d(TAG, "SKIPPABLE_STATE_CHANGED");
//        });
//
//        player.addListener(this, AdEvent.adRequested, event -> {
//            AdEvent.AdRequestedEvent adRequestEvent = event;
//            Log.d(TAG, "AD_REQUESTED adtag = " + adRequestEvent.adTagUrl);
//        });
//
//        player.addListener(this, AdEvent.playHeadChanged, event -> {
//            AdEvent.AdPlayHeadEvent adEventProress = event;
//            //Log.d(TAG, "received AD PLAY_HEAD_CHANGED " + adEventProress.adPlayHead);
//        });
//
//
//        player.addListener(this, AdEvent.adBreakStarted, event -> {
//            Log.d(TAG, "AD_BREAK_STARTED");
//            showAdsView();
//        });
//        player.addListener(this, AdEvent.adBreakEnded, event -> {
//        });
//
//        player.addListener(this, AdEvent.cuepointsChanged, event -> {
//            AdEvent.AdCuePointsUpdateEvent cuePointsList = event;
//            Log.d(TAG, "AD_CUEPOINTS_UPDATED HasPostroll = " + cuePointsList.cuePoints.hasPostRoll());
//            hasPostRoll = cuePointsList.cuePoints.hasPostRoll();
//            hasPreRoll = cuePointsList.cuePoints.hasPreRoll();
//            hasMidRoll = cuePointsList.cuePoints.hasMidRoll();
//
//        });
//        player.addListener(this, PlayerEvent.ended, event -> {
//            isPlayerEnded = true;
//            Log.d(TAG, "PlayerEnded");
//            try {
//                if (handler1 != null) {
//                    handler1.removeCallbacksAndMessages(null);
//                }
//                getBinding().skipIntro.setVisibility(View.GONE);
//                getBinding().skipRecap.setVisibility(View.GONE);
//                getBinding().skipCredits.setVisibility(View.GONE);
//                getBinding().progressBar.setVisibility(View.GONE);
//                if (objectAnimator != null) {
//                    objectAnimator.cancel();
//                    objectAnimator = null;
//                    getBinding().progressBar.setProgress(0);
//                }
//            } catch (Exception ignored) {
//
//            }
//
//        });
//
//        player.addListener(this, PlayerEvent.playbackInfoUpdated, event -> {
//            try {
//                long bitRate = event.playbackInfo.getVideoBitrate() / 1000;
//                ConvivaManager.convivaPlayerSetBitRate(bitRate);
//            } catch (Exception ex) {
//            }
//
//        });
//
//        player.addListener(this, PlayerEvent.videoTrackChanged, event -> {
//
//        });
//        player.addListener(this, PlayerEvent.playing, event -> {
//            if (player != null) {
//                try {
//                    ConvivaManager.convivaPlayerPlayReportRequest();
//                } catch (Exception ex) {
//                }
//                AdController adController = player.getController(AdController.class);
//                if (adController != null) {
//                    if (adController.isAdDisplayed()) {
//                        Log.d(TAG, "AD CONTROLLER API: " + adController.getAdCurrentPosition() + "/" + adController.getAdDuration());
//                    }
//                    adController.skip();
//                }
//            }
//            adRunning = false;
//            if (lockEnable) {
//                getBinding().rl1.setVisibility(View.GONE);
//                getBinding().volumeDialog.setVisibility(View.GONE);
//                getBinding().brightnessDialog.setVisibility(View.GONE);
//            } else {
//                getBinding().rl1.setVisibility(View.VISIBLE);
//                getBinding().volumeDialog.setVisibility(View.VISIBLE);
//                getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//                playContent();
//            }
//
//
//        });
//
//        player.addListener(this, PlayerEvent.playheadUpdated, event -> {
//            if (!isLivePlayer) {
//                if (playerTimeInSeconds(runningPlayer.getCurrentPosition()) > 0) {
//                    if (introStartTime != 0 && introEndTime != 0 || creditStartTime != 0 && creditEndTime != 0) {
//                        Log.w("introValues", runningPlayer.getCurrentPosition() + "----" + introStartTime + "----" + playerTimeInSeconds(runningPlayer.getCurrentPosition()));
//                        if (introStartTime == playerTimeInSeconds(runningPlayer.getCurrentPosition()) || playerTimeInSeconds(runningPlayer.getCurrentPosition()) > introStartTime && playerTimeInSeconds(runningPlayer.getCurrentPosition()) < introEndTime) {
//                            getBinding().skipIntro.setText(labelIntro);
//                            getBinding().skipIntro.setVisibility(View.VISIBLE);
//                            skipValue = 1;
//                            getBinding().skipRecap.setVisibility(View.GONE);
//                            getBinding().skipCredits.setVisibility(View.GONE);
//                        } else {
//                            getBinding().skipIntro.setText(labelIntro);
//                            getBinding().skipIntro.setVisibility(View.GONE);
//                            skipValue = -1;
//                        }
//
//                        if (recapStartTime == playerTimeInSeconds(runningPlayer.getCurrentPosition()) || playerTimeInSeconds(runningPlayer.getCurrentPosition()) > recapStartTime && playerTimeInSeconds(runningPlayer.getCurrentPosition()) < recapEndTime) {
//                            getBinding().skipRecap.setText(labelRecap);
//                            getBinding().skipRecap.setVisibility(View.VISIBLE);
//                            skipValue = 2;
//                            getBinding().skipIntro.setVisibility(View.GONE);
//                            getBinding().skipCredits.setVisibility(View.GONE);
//                        } else {
//                            getBinding().skipRecap.setText("");
//                            getBinding().skipRecap.setVisibility(View.GONE);
//                            skipValue = -1;
//                        }
//
//                        if (creditStartTime == playerTimeInSeconds(runningPlayer.getCurrentPosition()) || playerTimeInSeconds(runningPlayer.getCurrentPosition()) > creditStartTime && playerTimeInSeconds(runningPlayer.getCurrentPosition()) < creditEndTime) {
//                            if (!isSkipCreditVisible) {
//                                getBinding().progressBar.setVisibility(View.VISIBLE);
//                                objectAnimator = ObjectAnimator.ofInt(getBinding().progressBar, "progress", getBinding().progressBar.getProgress(), 100).setDuration(10000);
//                                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                                    @Override
//                                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                                        int progress = (int) valueAnimator.getAnimatedValue();
//                                        getBinding().progressBar.setProgress(progress);
//                                    }
//
//                                });
//                                objectAnimator.start();
//
//                                getBinding().skipCredits.setText(labelCredit);
//                                getBinding().skipCredits.setVisibility(View.VISIBLE);
//                                isPlayerSurfaceClicked = false;
//                                isSkipCreditVisible = true;
//                                isUserGeneratedCredit = false;
//                                hideSkipIntro();
//                            }
//                            skipValue = 3;
//                            getBinding().skipIntro.setVisibility(View.GONE);
//                            getBinding().skipRecap.setVisibility(View.GONE);
//
//
//                        } else {
//                            skipValue = -1;
//                            isUserGeneratedCredit = true;
//                            checkPercentagePlayedOfVideo();
//
//                        }
//                    } else {
//                        getBinding().skipIntro.setVisibility(View.GONE);
//                        getBinding().skipRecap.setVisibility(View.GONE);
//                        skipValue = -1;
//                        isUserGeneratedCredit = true;
//                        checkPercentagePlayedOfVideo();
//                    }
//                }
//            } else {
//                getBinding().skipIntro.setVisibility(View.GONE);
//                getBinding().skipRecap.setVisibility(View.GONE);
//                getBinding().skipCredits.setVisibility(View.GONE);
//            }
//        });
//
//
//        player.addListener(this, AdEvent.loaded, event -> {
//            showAdsView();
//            Map<String, Object> contentInfo = new HashMap<String, Object>();
//            try {
//                contentInfo.put(ConvivaSdkConstants.POD_INDEX, event.adInfo.getPodIndex());
//                contentInfo.put(ConvivaSdkConstants.POD_DURATION, event.adInfo.getAdDuration());
//                ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportAdBreakStarted(ConvivaSdkConstants.AdPlayer.CONTENT, ConvivaSdkConstants.AdType.CLIENT_SIDE, contentInfo);
//            } catch (Exception ignored) {
//            }
//        });
//
//        player.addListener(this, AdEvent.started, event -> {
//            isAdsRunning = true;
//            try {
//                ConvivaManager.convivaAdsEvent(baseActivity, event);
//            } catch (Exception ex) {
//            }
//            showAdsView();
//        });
//
//        player.addListener(this, AdEvent.adBreakReady, event -> {
//            try {
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.PLAYING);
//            } catch (Exception ex) {
//            }
//            Log.d(TAG, "PLay");
//        });
//
//
//        player.addListener(this, AdEvent.resumed, event -> {
//            try {
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.PLAYING);
//            } catch (Exception ex) {
//            }
//            adRunning = true;
//            showAdsView();
//            Log.d(TAG, "PLAY");
//        });
//
//        player.addListener(this, AdEvent.paused, event -> {
//            try {
//                if (ConvivaManager.getConvivaAdAnalytics(baseActivity) != null)
//                    ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.PAUSED);
//            } catch (Exception ex) {
//            }
//            isAdPause = true;
//            Log.d(TAG, "AD_PAUSED");
//        });
//        player.addListener(this, PlayerEvent.seeked, event -> {
//            try {
//                ConvivaManager.convivaPlayerSeekStoppedReportRequest(baseActivity);
//            } catch (Exception ex) {
//            }
//        });
//
//        player.addListener(this, PlayerEvent.seeking, event -> {
//            try {
//                ConvivaManager.convivaPlayerSeekStartedReportRequest(baseActivity);
//            } catch (Exception ex) {
//            }
//        });
//        player.addListener(this, AdEvent.skipped, event -> {
//            isAdsRunning = false;
//            checkFatalError();
//            try {
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.STOPPED);
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdEnded();
//                ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportAdBreakEnded();
//                ConvivaManager.removeConvivaAdsSession();
//            } catch (Exception ex) {
//            }
//            Log.d(TAG, "AD_SKIPPED");
//        });
//
//
//        player.addListener(this, AdEvent.allAdsCompleted, event -> {
//            Log.d(TAG, "AD_ALL_ADS_COMPLETED");
//            allAdsCompleted = true;
//            adRunning = false;
//            checkPostBinge(player);
//        });
//
//        player.addListener(this, AdEvent.completed, event -> {
//            isAdsRunning = false;
//            Log.d(TAG, "AD_COMPLETED");
//            try {
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.STOPPED);
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdEnded();
//                ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportAdBreakEnded();
//                ConvivaManager.removeConvivaAdsSession();
//            } catch (Exception ex) {
//            }
//            if (isPlayerEnded && isWaitingBinge) {
//                allAdsCompleted = true;
//                checkPostBinge(player);
//            } else if (exitPlayer && !isSeries) {
//                exitPlayeriew(player);
//            } else {
//                adRunning = false;
//                checkFatalError();
//            }
//
//        });
//
//        player.addListener(this, AdEvent.firstQuartile, event -> {
//            Log.d(TAG, "FIRST_QUARTILE");
//            adRunning = true;
//        });
//
//        player.addListener(this, AdEvent.midpoint, event -> {
//            Log.d(TAG, "MIDPOINT");
//            if (player != null) {
//                AdController adController = player.getController(AdController.class);
//                if (adController != null) {
//                    if (adController.isAdDisplayed()) {
//                        Log.d(TAG, "AD CONTROLLER API: " + adController.getAdCurrentPosition() + "/" + adController.getAdDuration());
//                    }
//                }
//            }
//        });
//
//        player.addListener(this, AdEvent.thirdQuartile, event -> {
//            Log.d(TAG, "THIRD_QUARTILE");
//        });
//
//        player.addListener(this, AdEvent.adBreakEnded, event -> {
//            Log.d(TAG, "AD_BREAK_ENDED");
//        });
//
//        player.addListener(this, AdEvent.adClickedEvent, event -> {
//            AdEvent.AdClickedEvent advtClickEvent = event;
//
//            Log.d(TAG, "AD_CLICKED url = " + advtClickEvent.clickThruUrl);
//        });
//
//
//        player.addListener(this, AdEvent.adBufferStart, event -> {
//            AdEvent.AdBufferStart adBufferStartEvent = event;
//            if (isAdsRunning) {
//                try {
//                    ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.BUFFERING);
//                } catch (Exception ex) {
//                }
//            }
//            Log.d(TAG, "AD_events-->>" + "AD_BUFFER_START");
//            showAdsView();
//        });
//
//        player.addListener(this, AdEvent.adBufferEnd, event -> {
//            AdEvent.AdBufferEnd adBufferEnd = event;
//            if (isAdsRunning) {
//                try {
//                    ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.PLAYING);
//                } catch (Exception ignored) {
//
//                }
//            }
//            Log.d(TAG, "AD_events-->>" + "AD_BUFFER_END");
//            showAdsView();
//        });
//
//
//        player.addListener(this, AdEvent.error, event -> {
//            AdEvent.Error adError = event;
//            if (player != null) {
//                isAdsRunning = false;
//                if (!isAdError) {
//                    isAdError = true;
//                    try {
//                        ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdFailed(adError.error.errorType.name());
//                        ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdEnded();
//                        ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportAdBreakEnded();
//                        ConvivaManager.removeConvivaAdsSession();
//                    } catch (Exception ex) {
//                    }
//                }
//                if (adError.error.errorType.name().toUpperCase().contains("QUIET_LOG_ERROR") || adError.error.errorType.name().toUpperCase().contains("VIDEO_PLAY_ERROR")) {
//                    if (lockEnable) {
//                        getBinding().rl1.setVisibility(View.GONE);
//                        getBinding().volumeDialog.setVisibility(View.GONE);
//                        getBinding().brightnessDialog.setVisibility(View.GONE);
//                    } else {
//                        getBinding().rl1.setVisibility(View.VISIBLE);
//                        getBinding().volumeDialog.setVisibility(View.VISIBLE);
//                        getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//                        playContent();
//                    }
//                }
//                if (hasPostRoll) {
//                    allAdsCompleted = true;
//                }
//                if (isPlayerEnded && isWaitingBinge) {
//                    allAdsCompleted = true;
//                    checkPostBinge(player);
//                } else {
//                    adRunning = false;
//                    allAdsCompleted = true;
//                }
//
//            }
//            Log.e(TAG, "AD_ERROR : " + adError.error.errorType.name());
//        });
//
//        player.addListener(this, PlayerEvent.error, event -> {
//            Log.e(TAG, "PLAYER ERROR " + event.error.message);
//        });
//    }
//
//    public void checkPostBinge(Player player) {
//        if (allAdsCompleted && isPlayerEnded && isWaitingBinge) {
//            allAdsCompleted = false;
//            isPlayerEnded = false;
//            if (isSeries && hasNextEpisode) {
//                getBinding().pBar.setVisibility(View.GONE);
//                setBingView(player);
//            }
//        } else if (exitPlayer && !isSeries) {
//            exitPlayeriew(player);
//        }
//    }
//
//    public void checkFatalError() {
//        adRunning = false;
//        if (isVideoError) {
//            playBackError();
//        } else {
//
//            if (lockEnable) {
//                getBinding().rl1.setVisibility(View.GONE);
//                getBinding().volumeDialog.setVisibility(View.GONE);
//                getBinding().brightnessDialog.setVisibility(View.GONE);
//            } else {
//                getBinding().rl1.setVisibility(View.VISIBLE);
//                getBinding().volumeDialog.setVisibility(View.VISIBLE);
//                getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//                playContent();
//
//            }
//
//        }
//
//    }
//
//    private void getAssetImage(Asset asset, String deviceid) {
//        if (asset.getImages().size() > 0) {
//
//            image_url = asset.getImages().get(0).getUrl();
//            image_url = image_url + AppLevelConstants.WIDTH + (int) getResources().getDimension(R.dimen.carousel_image_width) + AppLevelConstants.HEIGHT + (int) getResources().getDimension(R.dimen.carousel_image_height) + AppLevelConstants.QUALITY;
//        }
//        if (runningPlayer != null) {
//            runningPlayer.getView().setVisibility(View.GONE);
//            runningPlayer.stop();
//            hidePlayerControls();
//        }
//
//    }
//
//    private void getPlayerView(final Player player) {
//
//        runningPlayer = player;
//        View view = player.getView();
//        getBinding().rl.addView(view);
//
//        viewModel.playerCallback(assetPosition, baseActivity).observe(this, s -> {
//            if (TextUtils.isEmpty(s)) {
//                if (adRunning && AppCommonMethods.isAdsEnable) {
//                    isVideoError = true;
//                } else {
//
//                    player.pause();
//                    playBackError();
//                }
//            } else {
//                getBinding().totalDuration.setText(s);
//                final LiveData<Boolean> booleanLiveData = viewModel.getStateOfPlayer();
//                booleanLiveData.observe(baseActivity, aBoolean -> {
//
//                    hideSoftKeyButton();
//                    isPlayerStart = true;
//                    if (lockEnable) {
//                        getBinding().rl1.setVisibility(View.GONE);
//                        getBinding().listViewSettings.setVisibility(View.GONE);
//                        getBinding().volumeDialog.setVisibility(View.GONE);
//                        getBinding().brightnessDialog.setVisibility(View.GONE);
//                    } else {
//                        getBinding().rl1.setVisibility(View.VISIBLE);
//                        getBinding().listViewSettings.setVisibility(View.VISIBLE);
//                        getBinding().volumeDialog.setVisibility(View.VISIBLE);
//                        getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//                    }
//
//                    if (!adRunning)
//                        playContent();
//                    booleanLiveData.removeObservers(baseActivity);
//                    if (booleanLiveData.hasObservers()) return;
//                    if (aBoolean != null && aBoolean) {
//                        getBinding().pBar.setVisibility(View.GONE);
//                        haveAudioOrNot();
//                        haveSubtitleorNot();
//                        if (playerAsset.getType() != MediaTypeConstant.getLinear(getActivity()))
//                            setVideoQuality();
//                    }
//                });
//            }
//        });
//
//        viewModel.getSeekBarProgress(getBinding().seekBar).observe(this, s -> {
//            if (runningPlayer != null) {
//                runningPlayer.getView().setVisibility(View.VISIBLE);
//                long durtion = runningPlayer.getDuration();
//                long currentPos = runningPlayer.getCurrentPosition();
//
//                if (isPlayerStart) {
//
//                    if (currentPos > 10000) {
//                        getBinding().backward.setVisibility(View.VISIBLE);
//                    } else {
//                        getBinding().backward.setVisibility(View.GONE);
//                    }
//                    long runningTime = durtion - currentPos;
//                    if (runningTime > 10000) {
//                        getBinding().forward.setVisibility(View.VISIBLE);
//                    } else {
//                        getBinding().forward.setVisibility(View.GONE);
//                    }
//                    if (adRunning) {
//                        getBinding().listViewSettings.setVisibility(View.GONE);
//                        getBinding().rl1.setVisibility(View.GONE);
//                        getBinding().backward.setVisibility(View.GONE);
//                        getBinding().forward.setVisibility(View.GONE);
//                        getBinding().volumeDialog.setVisibility(View.GONE);
//                        getBinding().brightnessDialog.setVisibility(View.GONE);
//                    }
//
//
//                }
//
//            }
//
//
//            getBinding().currentTime.setText(s);
//        });
//        getBinding().ivCancel.setOnClickListener(view1 -> {
//            exitPlayeriew(player);
//
//        });
//
//
//        viewModel.getPlayerState().observe(this, aBoolean -> {
//            if (aBoolean != null && aBoolean) {
//                if (isSeries && hasNextEpisode) {
//                    if (hasPostRoll) {
//                        isWaitingBinge = true;
//                    } else {
//                        setBingView(player);
//                    }
//                } else {
//                    if (hasPostRoll) {
//                        exitPlayer = true;
//                    } else {
//                        exitPlayeriew(player);
//                    }
//                }
//            }
//        });
//
//    }
//
//    private void hideSoftKeyButton() {
//        View decorView = baseActivity.getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_IMMERSIVE
//                        // Set the content to appear under the system bars so that the
//                        // content doesn't resize when the system bars hide and show.
//                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        // Hide the nav bar and status bar
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
//
//    }
//
//    public void setBingView(Player player) {
//        getBinding().nextEpisode.setVisibility(View.GONE);
//        isBingeView = true;
//        isSkipCreditVisible = false;
//        hidePbar();
//        makeRlUpInvisible();
//        makeRlDownInvisible();
//
//        if (!hasEpisodesList)
//            getNextEpisode(asset);
//
//        startTimer();
//
//    }
//
//    private void getAssetImage(Asset asset) {
//        boolean ratioFound = false;
//        for (int i = 0; i < asset.getImages().size(); i++) {
//            if (asset.getImages().get(i).getRatio().equalsIgnoreCase("16:9")) {
//                image_url = asset.getImages().get(0).getUrl();
//                image_url = image_url + AppLevelConstants.WIDTH + (int) getResources().getDimension(R.dimen.landscape_image_width) + AppLevelConstants.HEIGHT + (int) getResources().getDimension(R.dimen.landscape_image_height) + AppLevelConstants.QUALITY;
//                ImageHelper.getInstance(getActivity()).loadImageTo(getBinding().autoplaylayout.assetImage, image_url, R.drawable.ic_landscape_placeholder);
//                ratioFound = true;
//            }
//        }
//        if (ratioFound) {
//            ImageHelper.getInstance(getActivity()).loadImageTo(getBinding().autoplaylayout.assetImage, image_url, R.drawable.ic_landscape_placeholder);
//        }
//    }
//
//    private void exitPlayeriew(Player player) {
//        getBinding().lockImg.setVisibility(View.VISIBLE);
//        getBinding().linearAutoPlayLayout.setVisibility(View.GONE);
//
//        if (timer && timeHandler != null) {
//            timeHandler.removeCallbacks(myRunnable);
//
//        }
//        PrintLogging.printLog(this.getClass(), "", "exitPlayeriew");
//
//        if (runningPlayer != null) {
//            PrintLogging.printLog(this.getClass(), "", "runningPlayer");
//            runningPlayer.stop();
//            runningPlayer.destroy();
//        }
//        if (player != null) {
//            PrintLogging.printLog(this.getClass(), "", "Player");
//
//            player.stop();
//            player.destroy();
//        }
//        if (viewModel != null)
//            viewModel.clearCallbacks();
//        if (baseActivity != null)
//            baseActivity.onBackPressed();
//    }
//
//    private void playBackError() {
//        getBinding().playButton.setVisibility(View.GONE);
//        getBinding().seekBar.setVisibility(View.GONE);
//        getBinding().currentTime.setVisibility(View.GONE);
//        getBinding().totalDuration.setVisibility(View.GONE);
//        getBinding().fullscreen.setVisibility(View.GONE);
//        getBinding().forward.setVisibility(View.GONE);
//        getBinding().backward.setVisibility(View.GONE);
//        getBinding().pBar.setVisibility(View.GONE);
//        getBinding().playericon.setVisibility(View.GONE);
//        getBinding().slash.setVisibility(View.GONE);
//        getBinding().subtitleAudio.setVisibility(View.GONE);
//        getBinding().quality.setVisibility(View.GONE);
//        getBinding().goLive.setVisibility(View.GONE);
//
//        if (!DialogHelper.isIsDialog()) {
//            if (getActivity() != null && !getActivity().isFinishing()) {
//                if (NetworkConnectivity.isOnline(getActivity())) {
//                    try {
//                        ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportPlaybackFailed("Playback Error");
//                    } catch (Exception ex) {
//                    }
//                    DialogHelper.playerAlertDialog(this.getActivity(), getString(R.string.play_back_error), getString(R.string.ok), new AlertDialogSingleButtonFragment.AlertDialogListener() {
//                        @Override
//                        public void onFinishDialog() {
//                            DialogHelper.setIsDialog(false);
//                            if (runningPlayer != null) {
//                                runningPlayer.stop();
//                                runningPlayer.destroy();
//                            }
//                            getActivity().finish();
//                        }
//                    });
//                }
//            }
//        }
//
//    }
//
//    private void setVideoQuality() {
//        selectedTrack = "High Quality";
//        if (!TextUtils.isEmpty(selectedTrack)) {
//            trackName = selectedTrack;
//            Log.d("TrackNameIs", trackName);
//            Log.d("TrackNameIs", selectedTrack);
//
//            final LiveData<Boolean> booleanLiveData = viewModel.changeInitialTrack(trackName, getBinding().quality);
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (getBinding().quality.getText().toString().equalsIgnoreCase("High Quality")) {
//                        trackName = "High Quality";
//                    } else if (getBinding().quality.getText().toString().equalsIgnoreCase("Medium Quality")) {
//                        trackName = "Medium Quality";
//                    } else if (getBinding().quality.getText().toString().equalsIgnoreCase("Low Quality")) {
//                        trackName = "Low Quality";
//                    }
//
//                    Log.d("TrackNameIs", trackName);
//                }
//
//            }, 700);
//
//        }
//    }
//
//    private void notPlayContentWithoutInternet() {
//        getBinding().playButton.setVisibility(View.VISIBLE);
//        getBinding().seekBar.setVisibility(View.GONE);
//        getBinding().currentTime.setVisibility(View.GONE);
//        getBinding().totalDuration.setVisibility(View.GONE);
//        getBinding().fullscreen.setVisibility(View.GONE);
//        getBinding().forward.setVisibility(View.GONE);
//        getBinding().backward.setVisibility(View.GONE);
//        getBinding().pBar.setVisibility(View.GONE);
//        getBinding().playericon.setVisibility(View.GONE);
//        getBinding().slash.setVisibility(View.GONE);
//        getBinding().subtitleAudio.setVisibility(View.GONE);
//        getBinding().quality.setVisibility(View.GONE);
//    }
//
//    private void callHandler() {
//        timer = true;
//        myRunnable = this::ShowAndHideView;
//
//        timeHandler = new Handler();
//        timeHandler.postDelayed(myRunnable, 3000);
//    }
//
//    private void ShowAndHideView() {
//        if (getBinding().imagePreview.getVisibility() == View.VISIBLE) {
//            getBinding().imagePreview.setVisibility(View.GONE);
//        }
//        Log.d("DragValueIs", drag + "");
//
//
//        if (drag)
//            return;
//
//        if (lockEnable)
//            return;
//
//        if (adRunning) {
//            return;
//        }
//
//        if (getBinding().videoDialog.getVisibility() == View.VISIBLE) {
//            return;
//        }
//
//        if (getBinding().audioDialog.getVisibility() == View.VISIBLE) {
//            return;
//        }
//
//
//        try {
//            animationFadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
//            animationFadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
//            animationFadeOut.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    getBinding().listViewSettings.setVisibility(View.GONE);
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//
//                }
//            });
//            if (getBinding().rl1.getVisibility() == View.VISIBLE) {
//                Log.d("HideView", "True");
//                getBinding().rl1.startAnimation(animationFadeOut);
//                getBinding().rl1.setVisibility(View.GONE);
//                getBinding().volumeDialog.setVisibility(View.GONE);
//                getBinding().brightnessDialog.setVisibility(View.GONE);
//                if (getBinding().videoDialog.getVisibility() == View.VISIBLE || getBinding().audioDialog.getVisibility() == View.VISIBLE) {
//                    getBinding().audioDialog.setVisibility(View.GONE);
//                    getBinding().videoDialog.setVisibility(View.GONE);
//                    getBinding().skipIntro.setClickable(true);
//                    getBinding().skipCredits.setClickable(true);
//                    getBinding().skipRecap.setClickable(true);
//                }
//                getBinding().listViewSettings.setVisibility(View.GONE);
//                timer = true;
//                hideSoftKeyButton();
//            } else {
//                Log.d("HideView", "False");
//                getBinding().rl1.setVisibility(View.VISIBLE);
//                getBinding().volumeDialog.setVisibility(View.VISIBLE);
//                getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//                if (isSeries) {
//                    if (getBinding().forward.getVisibility() == View.VISIBLE || getBinding().backward.getVisibility() == View.VISIBLE) {
//                        getBinding().playButton.setVisibility(View.VISIBLE);
//                        getBinding().rlDown.setVisibility(View.VISIBLE);
//                        getBinding().ivCancel.setVisibility(View.VISIBLE);
//                        getBinding().rlDown.setVisibility(View.VISIBLE);
//                        getBinding().totalDuration.setVisibility(View.VISIBLE);
//                        getBinding().seekBar.setVisibility(View.VISIBLE);
//                        getBinding().currentTime.setVisibility(View.VISIBLE);
//                        getBinding().listViewSettings.setVisibility(View.GONE);
//                        getBinding().slash.setVisibility(View.VISIBLE);
//                        getBinding().quality.setVisibility(View.VISIBLE);
//
//                    }
//                }
//                getBinding().rl1.startAnimation(animationFadeIn);
//
//                callHandler();
//            }
//        } catch (Exception ex) {
//
//        }
//    }
//
//    public boolean isDoubleTap;
//
//    public void showAllControls() {
//        if (getBinding().rlUp.getVisibility() != View.VISIBLE) {
//            getBinding().rlUp.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().rlUp.setVisibility(View.GONE);
//
//        }
//        if (getBinding().rlDown.getVisibility() != View.VISIBLE) {
//            getBinding().rlDown.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().rlDown.setVisibility(View.GONE);
//
//        }
//        if (getBinding().seekBar.getVisibility() != View.VISIBLE) {
//            getBinding().seekBar.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().seekBar.setVisibility(View.GONE);
//
//        }
//        if (getBinding().totalDuration.getVisibility() != View.VISIBLE) {
//            getBinding().totalDuration.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().totalDuration.setVisibility(View.GONE);
//
//        }
//        if (getBinding().currentTime.getVisibility() != View.VISIBLE) {
//            getBinding().currentTime.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().currentTime.setVisibility(View.GONE);
//
//        }
//        if (getBinding().slash.getVisibility() != View.VISIBLE) {
//            getBinding().slash.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().slash.setVisibility(View.GONE);
//
//        }
//        if (getBinding().llQualityAndSubtitile.getVisibility() != View.VISIBLE) {
//            getBinding().llQualityAndSubtitile.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().llQualityAndSubtitile.setVisibility(View.GONE);
//
//        }
//        showPlayerMediaControls();
//    }
//
//    @SuppressLint("ClickableViewAccessibility")
//    private void UIControllers() {
//
//        getBinding().seekBar.setProgress(0);
//        getBinding().seekBar.setMax(100);
//
//        getBinding().brightnessSeek.seekBar1.setProgress(50);
//        getBinding().brightnessSeek.seekBar1.setMax(100);
//        currBrightness = Settings.System.getInt(getActivity().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
//
//
//        getBinding().brightnessSeek.seekBar1.setOnSeekBarChangeListener(this);
//
//        getBinding().seekBar.setOnSeekBarChangeListener(this);
//
//
//        getBinding().volumeSeek.seekBar2.setOnSeekBarChangeListener(this);
//        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
//
//        getBinding().volumeSeek.seekBar2.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
//        getBinding().volumeSeek.seekBar2.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
//
//        gestureDetector = new GestureDetector(getActivity(), new SwipeGestureListener(bottomSheetBehavior, new DragListner() {
//            @Override
//            public void dragging(String name) {
//                if (name.equalsIgnoreCase("up")) {
//                    drag = true;
//                } else if (name.equalsIgnoreCase("down")) {
//                    Log.d("ElseCalled", "True");
//                    drag = false;
//                }
//            }
//        }));
//
//
//        getBinding().playericon.setOnClickListener(view -> {
//
//            isPlayerIconClick = true;
//            showAlertDialog(getResources().getString(R.string.purchase_dialouge), getResources().getString(R.string.login), getResources().getString(R.string.cancel));
//        });
//
//
//        getBinding().lockIcon.setOnClickListener(view -> {
//            if (lockEnable) {
//                if (timeHandler != null && timer) {
//                    timeHandler.removeCallbacks(myRunnable);
//                }
//                getBinding().lockImg.setImageResource(R.drawable.ic_lock_open);
//                lockEnable = false;
//                ShowAndHideView();
//
//            } else {
//                clearAndReset();
//                if (timer && timeHandler != null) {
//                    timeHandler.removeCallbacks(myRunnable);
//                }
//            }
//        });
//
//        getBinding().audioDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                return;
//            }
//        });
//
//        getBinding().rl.setOnClickListener(new DoubleClick(new DoubleClickListener() {
//            @Override
//            public void onSingleClick(View view) {
//
//                if (drag)
//                    drag = false;
//
//                if (isPlayerStart) {
//                    if (getBinding().skipCredits.getVisibility() == View.VISIBLE) {
//                        getBinding().skipCredits.setVisibility(View.GONE);
//                        getBinding().progressBar.setVisibility(View.GONE);
//                        if (objectAnimator != null) {
//                            objectAnimator.cancel();
//                            objectAnimator = null;
//                        }
//                        isPlayerSurfaceClicked = true;
//                        getBinding().progressBar.setProgress(0);
//                    }
//                    if (handler1 != null) {
//                        handler1.removeCallbacksAndMessages(null);
//                    }
//
//                    if (lockEnable) {
//                    } else {
//                        if (timer) {
//                            if (timeHandler != null)
//                                timeHandler.removeCallbacks(myRunnable);
//                        }
//                        if (getBinding().videoDialog.getVisibility() == View.VISIBLE) {
//                            getBinding().videoDialog.setVisibility(View.GONE);
//                        }
//                        if (getBinding().audioDialog.getVisibility() == View.VISIBLE) {
//                            getBinding().audioDialog.setVisibility(View.GONE);
//                            getBinding().skipIntro.setClickable(true);
//                            getBinding().skipCredits.setClickable(true);
//                            getBinding().skipRecap.setClickable(true);
//                        }
//                        ShowAndHideView();
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onDoubleClick(View view) {
//                if (runningPlayer.isPlaying()) {
//                    pausePlayer();
//                } else {
//                    if (runningPlayer != null) {
//                        runningPlayer.play();
//                        getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//                        Log.d("ftftftfftf", "Enterrl");
//                    }
//                }
//
//
//            }
//        }));
//        getBinding().rl1.setOnClickListener(new DoubleClick(new DoubleClickListener() {
//            @Override
//            public void onSingleClick(View view) {
//
//                if (isPlayerStart) {
//                    if (getBinding().skipCredits.getVisibility() == View.VISIBLE) {
//                        getBinding().skipCredits.setVisibility(View.GONE);
//                        getBinding().progressBar.setVisibility(View.GONE);
//                        if (objectAnimator != null) {
//                            objectAnimator.cancel();
//                            objectAnimator = null;
//                        }
//                        getBinding().progressBar.setProgress(0);
//                        isPlayerSurfaceClicked = true;
//                    }
//                    if (handler1 != null) {
//                        handler1.removeCallbacksAndMessages(null);
//                    }
//                    if (lockEnable) {
//
//                    } else {
//                        if (timer) {
//
//                            if (timeHandler != null)
//                                timeHandler.removeCallbacks(myRunnable);
//                        }
//                        if (getBinding().videoDialog.getVisibility() == View.VISIBLE) {
//                            getBinding().videoDialog.setVisibility(View.GONE);
//                        }
//                        if (getBinding().audioDialog.getVisibility() == View.VISIBLE) {
//                            getBinding().audioDialog.setVisibility(View.GONE);
//                            getBinding().skipIntro.setClickable(true);
//                            getBinding().skipCredits.setClickable(true);
//                            getBinding().skipRecap.setClickable(true);
//                        }
//                        ShowAndHideView();
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onDoubleClick(View view) {
//                if (runningPlayer.isPlaying()) {
//                    pausePlayer();
//                } else {
//                    if (runningPlayer != null) {
//                        runningPlayer.play();
//                        getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//                        Log.d("ftftftfftf", "Enterrl1");
//                    }
//                }
//            }
//        }));
//
//        getBinding().rl1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//
//                        //touch is start
//                        downX = event.getX();
//                        downY = event.getY();
//                        if (event.getX() < (sWidth / 2)) {
//
//                            //here check touch is screen left or right side
//                            intLeft = true;
//                            intRight = false;
//
//                        } else if (event.getX() > (sWidth / 2)) {
//
//                            //here check touch is screen left or right side
//                            intLeft = false;
//                            intRight = true;
//                        }
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                        if(!isDoubleTap){
//                            new DoubleTabAsyncTask(DTPlayer.this, MAX_DURATION).execute();
//
//                        }
//                        else{
//                            playPauseControl();
//                            showMediaPlayerControls();
//                            if(!adRunning){
//                                showCurrentTime();
//                                showSlash();
//                                showTotalDuration();
//                            }
//                        }
//
//                    case MotionEvent.ACTION_MOVE:
//                        Log.i("TOUCH_EVENTS", "rl_move");
//
//                        //finger move to screen
//                        float x2 = event.getX();
//                        float y2 = event.getY();
//
//                        diffX = (long) (Math.ceil(x2 - downX));
//                        diffY = (long) (Math.ceil(y2 - downY));
//
//                        if (Math.abs(diffY) > Math.abs(diffX)) {
//                            if (intLeft) {
//                                //if left its for brightness
//
//                                if (downY < y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_brightness_up");
//
//                                    if (currBrightness > 0) {
//                                        showBrightnessDialog();
//                                        currBrightness = currBrightness - 2;
//                                        Log.d("fgfgfgfgfg", currBrightness + "");
//                                        WindowManager.LayoutParams layout = getActivity().getWindow().getAttributes();
//                                        layout.screenBrightness = currBrightness / 100F;
//                                        getActivity().getWindow().setAttributes(layout);
//                                        getBinding().brightnessSeek.seekBar1.setProgress(currBrightness);
//                                    }
//                                    //down swipe brightness decrease
//                                } else if (downY > y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_brightness_down");
//
//                                    if (currBrightness < 100) {
//                                        showBrightnessDialog();
//                                        currBrightness = currBrightness + 2;
//                                        Log.d("fgfgfgfgfg", currBrightness + "");
//                                        WindowManager.LayoutParams layout = getActivity().getWindow().getAttributes();
//                                        layout.screenBrightness = currBrightness / 100F;
//                                        getActivity().getWindow().setAttributes(layout);
//                                        getBinding().brightnessSeek.seekBar1.setProgress(currBrightness);
//                                    }
//                                    //up  swipe brightness increase
//                                }
//
//                            } else if (intRight) {
//
//                                //if right its for audio
//                                if (downY < y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_volume_down");
//                                    showVolumeDialog();
//                                    //down swipe volume decrease
//                                    audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
//                                    getBinding().volumeSeek.seekBar2.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
//
//                                } else if (downY > y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_volume_up");
//                                    showVolumeDialog();
//                                    //up  swipe volume increase
//                                    mAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
//                                    getBinding().volumeSeek.seekBar2.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
//                                }
//                            }
//
//                        }
//
//                        if (!isTouchCaptured) {
//                            upX1 = event.getX();
//                            upY1 = event.getY();
//                            isTouchCaptured = true;
//                        } else {
//                            upX2 = event.getX();
//                            upY2 = event.getY();
//
//                            float deltaX = upX1 - upX2;
//                            float deltaY = upY1 - upY2;
//                            //HORIZONTAL SCROLL
//                            if (Math.abs(deltaX) > Math.abs(deltaY)) {
//
//
//                                if (Math.abs(deltaX) > min_distance) {
//                                    hideUIbeforDrag();
//                                    // left or right
//                                    if (deltaX < 0) {
//                                        Log.i("TOUCH_EVENTS", "rl_move_right");
//                                        runningPlayer.seekTo(runningPlayer.getCurrentPosition() + 2000);
//                                        getBinding().seekBar.setProgress((int) runningPlayer.getCurrentPosition());
//
//                                        if (isLivePlayer) {
//                                        } else {
//                                            positionInPercentage = Math.round((getBinding().seekBar.getProgress() * 100 / runningPlayer.getDuration()));
//                                            Log.d("Positionperc", positionInPercentage + "");
//
//                                            float leftMargin = getBinding().seekBar.getWidth() * positionInPercentage / 100;
//
//
//                                            if (leftMargin < (getBinding().seekBar.getWidth() + (4 * getBinding().currentTime.getPaddingLeft() - 90) - getBinding().currentTime.getWidth())) {
//                                                getBinding().imagePreview.setTranslationX(leftMargin);
//                                            }
//                                            try {
//                                                if (previewImagesHashMap != null) {
//                                                    Bitmap bitmap = previewImagesHashMap.get(String.valueOf(positionInPercentage));
//                                                    if (bitmap != null) {
//                                                        getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                        getBinding().imagePreview.setImageBitmap(bitmap);
//                                                        getBinding().imagePreview.bringToFront();
//                                                    }
//                                                } else {
//                                                    getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                    getBinding().imagePreview.bringToFront();
//                                                }
//
//                                            } catch (Exception e) {
//
//                                            }
//                                        }
//
//                                        viewModel.sendSeekBarProgress(getBinding().seekBar.getProgress()).observe(getActivity(), s -> getBinding().currentTime.setText(s));
//
//                                        return true;
//                                    }
//                                    if (deltaX > 0) {
//                                        Log.i("TOUCH_EVENTS", "rl_move_left");
//                                        runningPlayer.seekTo(runningPlayer.getCurrentPosition() - 2000);
//                                        getBinding().seekBar.setProgress((int) runningPlayer.getCurrentPosition());
//
//                                        if (isLivePlayer) {
//                                        } else {
//                                            positionInPercentage = Math.round((getBinding().seekBar.getProgress() * 100 / runningPlayer.getDuration()));
//                                            Log.d("Positionperc", positionInPercentage + "");
//
//                                            float leftMargin = getBinding().seekBar.getWidth() * positionInPercentage / 100;
//
//                                            if (leftMargin < (getBinding().seekBar.getWidth() + (4 * getBinding().currentTime.getPaddingLeft() - 90) - getBinding().currentTime.getWidth())) {
//                                                getBinding().imagePreview.setTranslationX(leftMargin);
//                                            }
//                                            try {
//
//
//                                                if (previewImagesHashMap != null) {
//                                                    Bitmap bitmap = previewImagesHashMap.get(String.valueOf(positionInPercentage));
//                                                    if (bitmap != null) {
//                                                        getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                        getBinding().imagePreview.setImageBitmap(bitmap);
//                                                        getBinding().imagePreview.bringToFront();
//                                                    }
//                                                } else {
//                                                    getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                    getBinding().imagePreview.bringToFront();
//                                                }
//
//                                            } catch (Exception e) {
//
//                                            }
//                                        }
//
//                                        viewModel.sendSeekBarProgress(getBinding().seekBar.getProgress()).observe(getActivity(), s -> getBinding().currentTime.setText(s));
//                                        return true;
//                                    }
//                                } else {
//                                    //not long enough swipe...
//                                    getBinding().imagePreview.setVisibility(View.GONE);
//                                    return false;
//                                }
//                            }
//                        }
//                }
//                return false;
//            }
//        });
//        getBinding().rl.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        startTime1 = System.currentTimeMillis();
//                        clickCount++;
//                        //touch is start
//                        downX = event.getX();
//                        downY = event.getY();
//                        if (event.getX() < (sWidth / 2)) {
//
//                            //here check touch is screen left or right side
//                            intLeft = true;
//                            intRight = false;
//
//                        } else if (event.getX() > (sWidth / 2)) {
//
//                            //here check touch is screen left or right side
//                            intLeft = false;
//                            intRight = true;
//                        }
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                        if(!isDoubleTap){
//                            new DoubleTabAsyncTask(DTPlayer.this, MAX_DURATION).execute();
//
//                        }
//                        else{
//                            playPauseControl();
//                            showMediaPlayerControls();
//                            if(!adRunning){
//                                showCurrentTime();
//                                showSlash();
//                                showTotalDuration();
//                            }
//                        }
//
//
//                    case MotionEvent.ACTION_MOVE:
//
//                        //finger move to screen
//                        float x2 = event.getX();
//                        float y2 = event.getY();
//
//                        diffX = (long) (Math.ceil(event.getX() - downX));
//                        diffY = (long) (Math.ceil(event.getY() - downY));
//
//                        if (Math.abs(diffY) > Math.abs(diffX)) {
//                            if (intLeft) {
//                                //if left its for brightness
//                                if (downY < y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_brightness_up");
//
//                                    if (currBrightness > 0) {
//                                        showBrightnessDialog();
//                                        currBrightness = currBrightness - 2;
//                                        Log.d("fgfgfgfgfg", currBrightness + "");
//                                        WindowManager.LayoutParams layout = getActivity().getWindow().getAttributes();
//                                        layout.screenBrightness = currBrightness / 100F;
//                                        getActivity().getWindow().setAttributes(layout);
//                                        getBinding().brightnessSeek.seekBar1.setProgress(currBrightness);
//                                    }
//                                    //down swipe brightness decrease
//                                } else if (downY > y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_brightness_down");
//
//                                    if (currBrightness < 100) {
//                                        showBrightnessDialog();
//                                        currBrightness = currBrightness + 2;
//                                        Log.d("fgfgfgfgfg", currBrightness + "");
//                                        WindowManager.LayoutParams layout = getActivity().getWindow().getAttributes();
//                                        layout.screenBrightness = currBrightness / 100F;
//                                        getActivity().getWindow().setAttributes(layout);
//                                        getBinding().brightnessSeek.seekBar1.setProgress(currBrightness);
//                                    }
//                                    //up  swipe brightness increase
//                                }
//
//                            } else if (intRight) {
//
//                                //if right its for audio
//                                if (downY < y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_volume_down");
//                                    showVolumeDialog();
//                                    //down swipe volume decrease
//                                    audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
//                                    getBinding().volumeSeek.seekBar2.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
//
//                                } else if (downY > y2) {
//                                    Log.i("TOUCH_EVENTS", "rl_UP_move_left_volume_up");
//                                    showVolumeDialog();
//                                    mAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
//                                    getBinding().volumeSeek.seekBar2.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
//                                }
//                            }
//                        }
//
//                        if (!isTouchCaptured) {
//                            upX1 = event.getX();
//                            upY1 = event.getY();
//                            isTouchCaptured = true;
//                        } else {
//                            upX2 = event.getX();
//                            upY2 = event.getY();
//
//                            float deltaX = upX1 - upX2;
//                            float deltaY = upY1 - upY2;
//
//                            //HORIZONTAL SCROLL
//                            if (Math.abs(deltaX) > Math.abs(deltaY)) {
//                                if (Math.abs(deltaX) > min_distance) {
//                                    // left or right
//                                    hideUIbeforDrag();
//                                    // left or right
//                                    if (deltaX < 0) {
//                                        Log.i("TOUCH_EVENTS", "rl_move_right");
//                                        runningPlayer.seekTo(runningPlayer.getCurrentPosition() + 2000);
//                                        getBinding().seekBar.setProgress((int) runningPlayer.getCurrentPosition());
//
//                                        if (isLivePlayer) {
//                                        } else {
//                                            positionInPercentage = Math.round((getBinding().seekBar.getProgress() * 100 / runningPlayer.getDuration()));
//                                            Log.d("Positionperc", positionInPercentage + "");
//
//                                            float leftMargin = getBinding().seekBar.getWidth() * positionInPercentage / 100;
//
//
////
//                                            if (leftMargin < (getBinding().seekBar.getWidth() + (4 * getBinding().currentTime.getPaddingLeft() - 90) - getBinding().currentTime.getWidth())) {
//                                                getBinding().imagePreview.setTranslationX(leftMargin);
//                                            }
////
//                                            try {
//                                                if (previewImagesHashMap != null) {
//                                                    Bitmap bitmap = previewImagesHashMap.get(String.valueOf(positionInPercentage));
//                                                    if (bitmap != null) {
//                                                        getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                        getBinding().imagePreview.setImageBitmap(bitmap);
//                                                        getBinding().imagePreview.bringToFront();
//                                                    }
//                                                } else {
//                                                    getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                    getBinding().imagePreview.bringToFront();
//                                                }
//
//                                            } catch (Exception e) {
//
//                                            }
//                                        }
//
//                                        viewModel.sendSeekBarProgress(getBinding().seekBar.getProgress()).observe(getActivity(), s -> getBinding().currentTime.setText(s));
//
//                                        return true;
//                                    }
//                                    if (deltaX > 0) {
//                                        Log.i("TOUCH_EVENTS", "rl_move_left");
//                                        runningPlayer.seekTo(runningPlayer.getCurrentPosition() - 2000);
//                                        getBinding().seekBar.setProgress((int) runningPlayer.getCurrentPosition());
//
//                                        if (isLivePlayer) {
//                                        } else {
//                                            positionInPercentage = Math.round((getBinding().seekBar.getProgress() * 100 / runningPlayer.getDuration()));
//                                            Log.d("Positionperc", positionInPercentage + "");
//
//                                            float leftMargin = getBinding().seekBar.getWidth() * positionInPercentage / 100;
//
//                                            if (leftMargin < (getBinding().seekBar.getWidth() + (4 * getBinding().currentTime.getPaddingLeft() - 90) - getBinding().currentTime.getWidth())) {
//                                                //previewImage.translationX = leftMargin
//                                                getBinding().imagePreview.setTranslationX(leftMargin);
//                                            }
////
////
//                                            try {
//
//
//                                                if (previewImagesHashMap != null) {
//                                                    Bitmap bitmap = previewImagesHashMap.get(String.valueOf(positionInPercentage));
//                                                    if (bitmap != null) {
//                                                        getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                        getBinding().imagePreview.setImageBitmap(bitmap);
//                                                        getBinding().imagePreview.bringToFront();
//                                                    }
//                                                } else {
//                                                    getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                                    getBinding().imagePreview.bringToFront();
//                                                }
//
//                                            } catch (Exception e) {
//
//                                            }
//                                        }
//
//                                        viewModel.sendSeekBarProgress(getBinding().seekBar.getProgress()).observe(getActivity(), s -> getBinding().currentTime.setText(s));
//                                        return true;
//                                    }
//                                } else {
//                                    //not long enough swipe...
//                                    getBinding().imagePreview.setVisibility(View.GONE);
//                                    return false;
//                                }
//                            }
//                        }
//                }
//                return false;
//            }
//        });
//
//
//
//        getBinding().forward.setOnClickListener(view -> {
//            showPbar();
//            if (objectAnimator != null) {
//                objectAnimator.cancel();
//                objectAnimator = null;
//                getBinding().progressBar.setProgress(0);
//            }
//
//            final LiveData<Boolean> booleanLiveData = viewModel.seekPlayerForward();
//            if (booleanLiveData == null || baseActivity == null) {
//                return;
//            }
//            booleanLiveData.observe(baseActivity, aBoolean -> {
//
//                booleanLiveData.removeObservers(baseActivity);
//                if (booleanLiveData.hasObservers()) return;
//                if (aBoolean != null && aBoolean) {
//                    hidePbar();
//                }
//                try {
//                    getBinding().seekBar.setProgress(((int) runningPlayer.getCurrentPosition()));
//                    getBinding().currentTime.setText(stringForTime(getBinding().seekBar.getProgress()));
//
//                } catch (Exception w) {
//                    PrintLogging.printLog("Exception", "", "" + w);
//                }
//            });
//        });
//
//
//        getBinding().goLive.setOnClickListener(view -> {
//            showPbar();
//            final LiveData<Boolean> booleanLiveData = viewModel.seekToDuration();
//            if (booleanLiveData == null || baseActivity == null) {
//                return;
//            }
//            booleanLiveData.observe(baseActivity, aBoolean -> {
//
//                booleanLiveData.removeObservers(baseActivity);
//                if (booleanLiveData.hasObservers()) return;
//                if (aBoolean != null && aBoolean) {
//                    hidePbar();
//                }
//                try {
//                    getBinding().seekBar.setProgress(((int) runningPlayer.getCurrentPosition()));
//                    getBinding().currentTime.setText(stringForTime(getBinding().seekBar.getProgress()));
//
//                } catch (Exception w) {
//                    PrintLogging.printLog("Exception", "", "" + w);
//                }
//            });
//        });
//
//        getBinding().backward.setOnClickListener(view -> {
//            getBinding().skipCredits.setText("");
//            getBinding().skipCredits.setVisibility(View.GONE);
//            getBinding().progressBar.setVisibility(View.GONE);
//            if (objectAnimator != null) {
//                objectAnimator.cancel();
//                objectAnimator = null;
//            }
//            if (handler1 != null) {
//                handler1.removeCallbacksAndMessages(null);
//            }
//            getBinding().progressBar.setProgress(0);
//            isSkipCreditVisible = false;
//            showPbar();
//
//            final LiveData<Boolean> booleanLiveData = viewModel.seekPlayerBackward();
//            if (booleanLiveData == null || baseActivity == null) {
//                return;
//            }
//            booleanLiveData.observe(baseActivity, aBoolean -> {
//                booleanLiveData.removeObservers(baseActivity);
//                if (booleanLiveData.hasObservers()) return;
//                if (aBoolean != null && aBoolean) {
//                    hidePbar();
//                }
//                try {
//                    getBinding().seekBar.setProgress(((int) runningPlayer.getCurrentPosition()));
//                    getBinding().currentTime.setText(stringForTime(getBinding().seekBar.getProgress()));
//                } catch (Exception e) {
//                    PrintLogging.printLog("Exception", "", "" + e);
//                }
//
//            });
//        });
//
//
//        getBinding().playButton.setOnClickListener(view -> playPauseControl());
//
//
//        getBinding().quality.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (getBinding().audioDialog.getVisibility() == View.VISIBLE) {
//                    getBinding().audioDialog.setVisibility(View.GONE);
//                    getBinding().skipIntro.setClickable(true);
//                    getBinding().skipCredits.setClickable(true);
//                    getBinding().skipRecap.setClickable(true);
//                }
//                chooseVideoquality();
//            }
//        });
//
//        getBinding().subtitleAudio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (getBinding().videoDialog.getVisibility() == View.VISIBLE) {
//                    getBinding().videoDialog.setVisibility(View.GONE);
//                }
//                Log.w("audioAndSubtitle", "in");
//                chooseAudio();
//            }
//        });
//
//        getBinding().nextEpisode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getBinding().nextEpisode.setVisibility(View.GONE);
//                getBinding().skipIntro.setVisibility(View.GONE);
//                getBinding().skipRecap.setVisibility(View.GONE);
//                getBinding().skipCredits.setVisibility(View.GONE);
//                if (objectAnimator != null) {
//                    objectAnimator.cancel();
//                    objectAnimator = null;
//                }
//                if (handler1 != null) {
//                    handler1.removeCallbacksAndMessages(null);
//                }
//                getBinding().progressBar.setProgress(0);
//                isSkipCreditVisible = false;
//                playNextEpisode();
//            }
//        });
//
//        getBinding().fullscreen.setOnClickListener(view -> getBinding().ivCancel.performClick());
//
//        getBinding().skipIntro.setOnClickListener(v -> {
//            getBinding().skipIntro.setVisibility(View.GONE);
//            if (introEndTime > playerTimeInSeconds(runningPlayer.getCurrentPosition())) {
//                runningPlayer.seekTo((introEndTime * 1000) + 500);
//            }
//        });
//
//        getBinding().skipCredits.setOnClickListener(v -> {
//            handler1.removeCallbacksAndMessages(null);
//            if (asset.getType() == MediaTypeConstant.getEpisode(getActivity())) {
//                if (isUserGeneratedCredit) {
//                    getBinding().skipCredits.setVisibility(View.GONE);
//                    getBinding().nextEpisode.setVisibility(View.GONE);
//                    getBinding().progressBar.setVisibility(View.GONE);
//                    if (objectAnimator != null) {
//                        objectAnimator.cancel();
//                        objectAnimator = null;
//                    }
//                    getBinding().progressBar.setProgress(0);
//                    playNextEpisode();
//                } else {
//                    if (creditEndTime < recapStartTime || creditEndTime < introStartTime) {
//                        getBinding().skipCredits.setVisibility(View.GONE);
//                        getBinding().progressBar.setVisibility(View.GONE);
//                        runningPlayer.seekTo(runningPlayer.getCurrentPosition() + 10000);
//                        if (objectAnimator != null) {
//                            objectAnimator.cancel();
//                            objectAnimator = null;
//                        }
//                        getBinding().progressBar.setProgress(0);
//                    } else {
//                        getBinding().nextEpisode.setVisibility(View.GONE);
//                        getBinding().skipCredits.setVisibility(View.GONE);
//                        getBinding().progressBar.setVisibility(View.GONE);
//                        if (objectAnimator != null) {
//                            objectAnimator.cancel();
//                            objectAnimator = null;
//                        }
//                        getBinding().progressBar.setProgress(0);
//                        playNextEpisode();
//                    }
//                }
//            } else {
//                getBinding().skipCredits.setVisibility(View.GONE);
//                getBinding().progressBar.setVisibility(View.GONE);
//                runningPlayer.seekTo(runningPlayer.getCurrentPosition() + 10000);
//                if (objectAnimator != null) {
//                    objectAnimator.cancel();
//                    objectAnimator = null;
//                }
//                getBinding().progressBar.setProgress(0);
//            }
//
//        });
//
//
//        getBinding().skipRecap.setOnClickListener(v -> {
//            getBinding().skipRecap.setVisibility(View.GONE);
//            if (recapEndTime > playerTimeInSeconds(runningPlayer.getCurrentPosition())) {
//                runningPlayer.seekTo((recapEndTime * 1000) + 500);
//            }
//        });
//
//
//    }
//
//    private void hideSlash() {
//        if (getBinding().slash.getVisibility() == View.VISIBLE) {
//            getBinding().slash.setVisibility(View.GONE);
//        }
//    }
//
//    private void showSlash() {
//        if (getBinding().slash.getVisibility() != View.VISIBLE) {
//            getBinding().slash.setVisibility(View.VISIBLE);
//        }
//    }
//
//    void clearAndReset() {
//        getBinding().rl1.clearAnimation();
//        getBinding().rl1.setVisibility(View.GONE);
//        getBinding().volumeDialog.setVisibility(View.GONE);
//        getBinding().brightnessDialog.setVisibility(View.GONE);
//        getBinding().listViewSettings.setVisibility(View.GONE);
//        if (animationFadeIn != null)
//            animationFadeIn.cancel();
//        if (animationFadeOut != null)
//            animationFadeOut.cancel();
//        getBinding().lockImg.setImageResource(R.drawable.ic_lock);
//        lockEnable = true;
//    }
//
//    void startTimer() {
//        playNextEpisode();
//    }
//
//
//    private void getScreenSize() {
//        display = getActivity().getWindowManager().getDefaultDisplay();
//        size = new Point();
//        display.getSize(size);
//        sWidth = size.x;
//        sHeight = size.y;
//    }
//
//    private void playNextEpisode() {
//        isPlayerSurfaceClicked = false;
//        isLiveChannel = false;
//        try {
//            ConvivaManager.convivaPlayerStoppedReportRequest();
//            ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportPlaybackEnded();
//            ConvivaManager.removeConvivaSession();
//        } catch (Exception ex) {
//        }
//        cancelTimer();
//        if (hasNextEpisode) {
//            if (runningPlayer != null) {
//                //  getBinding().lockIcon.setVisibility(View.VISIBLE);
//                getBinding().rlUp.setVisibility(View.VISIBLE);
//                getBinding().rlDown.setVisibility(View.VISIBLE);
//                runningPlayer.getView().setVisibility(View.GONE);
//                runningPlayer.stop();
//                hidePlayerControls();
//            }
//
//            if (nextPlayingAsset != null) {
//                asset = nextPlayingAsset;
//                Handler mHandler = new Handler();
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        isBingeView = false;
//                        checkErrors(asset);
//                    }
//                }, 3000);
//                playerChecks(asset);
//            }
//        } else {
//            if (runningPlayer != null)
//                exitPlayeriew(runningPlayer);
//        }
//    }
//
//    void cancelTimer() {
//        if (cTimer != null)
//            cTimer.cancel();
//    }
//
//    private void chooseQuality_Caption_Audio() {
//        isDialogShowing = true;
//        ArrayList<String> videoQualityArrayList = new ArrayList<>();
//        videoQualityArrayList.add(getString(R.string.video_quality));
//        if (isAudioTracks) {
//            videoQualityArrayList.add(getString(R.string.audio));
//        }
//        if (isCaption) {
//            videoQualityArrayList.add(getString(R.string.subtitle));
//        }
//        ArrayAdapter<String> arrayAdapter;
//
//        arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_layout, R.id.tv_setting_text, videoQualityArrayList);
//        getBinding().listViewSettings.setAdapter(arrayAdapter);
//        getBinding().listViewSettings.setVisibility(View.VISIBLE);
//        getBinding().listViewSettings.setOnItemClickListener((parent, view, position, id) -> {
//            getBinding().listViewSettings.setVisibility(View.GONE);
//            switch (position) {
//                case 0:
//                    chooseVideoquality();
//                    break;
//                case 1:
//                    if (isAudioTracks) {
//                        chooseAudio();
//                    } else {
////                        chooseCaption();
//                    }
//                    break;
//                case 2:
////                    chooseCaption();
//                    break;
//
//
//            }
//        });
//    }
//
//    private void chooseQualityDialouge() {
//        Dialog videodialog = new Dialog(baseActivity, android.R.style.Theme_Dialog);
//        videodialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        videodialog.setContentView(R.layout.video_quality);
//        videodialog.setCanceledOnTouchOutside(true);
//
//        videodialog.setCanceledOnTouchOutside(true);
//        if (videodialog.getWindow() != null) {
//            videodialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//            videodialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//            videodialog.show();
//        }
//
//    }
//
//    private void addAudioToPlayer() {
//        dialog.cancel();
//        final RecyclerView recycleview;
//        View modalbottomsheet1 = getLayoutInflater().inflate(R.layout.bottom_sheet_layout_audio, null);
//        dialogAudio = new BottomSheetDialog(baseActivity);
//        dialogAudio.setContentView(modalbottomsheet1);
//        dialogAudio.show();
//        recycleview = dialogAudio.findViewById(R.id.recycleview);
//        if (recycleview != null) {
//            recycleview.setLayoutManager(new LinearLayoutManager(baseActivity));
//            viewModel.loadAudioWithPlayer().observe(this, audioTracks -> {
//                if (audioTracks != null && audioTracks.size() > 0) {
//
//                    viewModel.getAudioTrackItems().observe(baseActivity, trackItems -> {
//
//                        AudioAdapter audioAdapter = new AudioAdapter(trackItems);
//                        recycleview.setAdapter(audioAdapter);
//                    });
//
//
//                } else {
//                    dialogAudio.cancel();
//                    callHandler();
//                    ToastHandler.show(baseActivity.getResources().getString(R.string.no_tracks_available), baseActivity.getApplicationContext());
//                }
//
//            });
//        }
//
//    }
//
//    private void addCaptionToPlayer() {
//        dialog.cancel();
//        final RecyclerView recycleview;
//        View modalbottomsheet1 = getLayoutInflater().inflate(R.layout.bottom_sheet_layout_caption, null);
//        dialogCaption = new BottomSheetDialog(baseActivity);
//        dialogCaption.setContentView(modalbottomsheet1);
//        dialogCaption.show();
//        recycleview = dialogCaption.findViewById(R.id.recycleview);
//        if (recycleview != null) {
//            recycleview.setLayoutManager(new LinearLayoutManager(baseActivity));
//            viewModel.loadCaptionWithPlayer().observe(this, textTracks -> {
//                if (textTracks != null && textTracks.size() > 0) {
//
//                    viewModel.getTextTrackItems().observe(baseActivity, trackItems -> {
//                        CaptionAdapter captionAdapter = new CaptionAdapter(trackItems);
//                        recycleview.setAdapter(captionAdapter);
//                    });
//
//
//                } else {
//                    dialogCaption.cancel();
//                    callHandler();
//                    ToastHandler.show(baseActivity.getResources().getString(R.string.no_caption_available), baseActivity.getApplicationContext());
//                }
//
//            });
//        }
//    }
//
//    public void haveSubtitleorNot() {
//        viewModel.loadCaptionWithPlayer().observe(this, textTracks -> {
//            if (textTracks != null && textTracks.size() > 0) {
//                viewModel.getTextTrackItems().observe(baseActivity, trackItems -> {
//                    if (trackItems.length > 0) {
//                        isCaption = true;
//                        captionList = trackItems.clone();
//
//                    } else {
//                        isCaption = false;
//
//                    }
//                });
//
//
//            } else {
//
//                isCaption = false;
//            }
//
//        });
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (isCaption || isAudioTracks) {
//                    getBinding().subtitleAudio.setVisibility(View.VISIBLE);
//                } else {
//                    getBinding().subtitleAudio.setVisibility(View.GONE);
//                }
//            }
//        }, 2000);
//    }
//
//    private void chooseAudio() {
//        if (getBinding().audioQuality.recycleviewAudio != null) {
//            Log.w("audioAndSubtitle", "in2");
//            getBinding().audioQuality.recycleviewAudio.setLayoutManager(new LinearLayoutManager(baseActivity));
//            getBinding().audioQuality.recycleviewAudio.setNestedScrollingEnabled(false);
//            viewModel.loadAudioWithPlayer().observe(this, audioTracks -> {
//                Log.w("audioAndSubtitle", "in3");
//                if (audioTracks != null && audioTracks.size() > 0) {
//                    Log.w("audioAndSubtitle", "in4");
//                    viewModel.getAudioTrackItems().observe(baseActivity, trackItems -> {
//                        Log.w("audioAndSubtitle", "in5");
//                        if (trackItems.length > 0) {
//                            Log.w("audioAndSubtitle", "in6");
//                            Log.w("audioAndSubtitle", trackItems + "   " + audioTracks.get(0).getLabel());
//                            if (audioTracks.get(0).getLanguage() != null) {
//                                audioList = trackItems;
//                                AudioAdapter audioAdapter = new AudioAdapter(trackItems);
//                                getBinding().audioQuality.recycleviewAudio.setAdapter(audioAdapter);
//                            } else {
//                                audioList = null;
//                                getBinding().audioQuality.recycleviewAudio.setVisibility(View.GONE);
//                                getBinding().audioQuality.titleAudio.setVisibility(View.GONE);
//                            }
//
//                        } else {
//                            Log.w("audioAndSubtitle", "in7");
//                            getBinding().audioQuality.recycleviewAudio.setVisibility(View.GONE);
//                            getBinding().audioQuality.titleAudio.setVisibility(View.GONE);
//                        }
//
//                    });
//
//
//                } else {
//                    getBinding().audioQuality.recycleviewAudio.setVisibility(View.GONE);
//                    getBinding().audioQuality.titleAudio.setVisibility(View.GONE);
//                }
//
//            });
//        }
//
//
//        if (getBinding().audioQuality.recycleviewSubtitle != null) {
//            getBinding().audioQuality.recycleviewSubtitle.setLayoutManager(new LinearLayoutManager(baseActivity));
//            getBinding().audioQuality.recycleviewSubtitle.setNestedScrollingEnabled(false);
//            viewModel.loadCaptionWithPlayer().observe(this, textTracks -> {
//                if (textTracks != null && textTracks.size() > 0) {
//
//                    viewModel.getTextTrackItems().observe(baseActivity, trackItems -> {
//                        if (trackItems.length > 0) {
//                            captionList = trackItems;
//                            CaptionAdapter captionAdapter = new CaptionAdapter(trackItems);
//                            getBinding().audioQuality.recycleviewSubtitle.setAdapter(captionAdapter);
//                        } else {
//                            getBinding().audioQuality.recycleviewSubtitle.setVisibility(View.GONE);
//                            getBinding().audioQuality.titleSubtitle.setVisibility(View.GONE);
//                        }
//                    });
//
//
//                } else {
//                    getBinding().audioQuality.recycleviewSubtitle.setVisibility(View.GONE);
//                    getBinding().audioQuality.titleSubtitle.setVisibility(View.GONE);
//                }
//
//            });
//        }
//
//        if (captionList != null || audioList != null) {
//            getBinding().audioDialog.setVisibility(View.VISIBLE);
//            getBinding().audioDialog.bringToFront();
//            getBinding().skipIntro.setClickable(false);
//            getBinding().skipCredits.setClickable(false);
//            getBinding().skipRecap.setClickable(false);
//        } else {
//
//            getBinding().audioDialog.setVisibility(View.GONE);
//            getBinding().skipIntro.setClickable(true);
//            getBinding().skipCredits.setClickable(true);
//            getBinding().skipRecap.setClickable(true);
//
//        }
//
//
//
//
//    }
//
//    private void chooseVideoquality() {
//        if (getBinding().videoQuality.recycleview != null) {
//            getBinding().videoQuality.recycleview.setLayoutManager(new LinearLayoutManager(baseActivity));
//            viewModel.loadVideotracksWithPlayer().observe(this, videoTracks -> {
//                if (videoTracks != null && videoTracks.size() > 0) {
//                    viewModel.getVideoTrackItems().observe(baseActivity, trackItems -> {
//                        if (trackItems.size() > 0) {
//                            getBinding().videoDialog.setVisibility(View.VISIBLE);
//                            getBinding().videoDialog.bringToFront();
//                            trackItemList = trackItems;
//
//                            for (int i = 0; i < trackItemList.size(); i++) {
//                                if (trackName.equalsIgnoreCase("")) {
//
//                                } else {
//                                    String compareName = trackItemList.get(i).getTrackName();
//                                    if (trackName.equals(compareName)) {
//                                        trackItemList.get(i).setSelected(true);
//                                        break;
//                                    } else {
//                                        trackItemList.get(i).setSelected(false);
//                                    }
//                                }
//                            }
//                            VideoTracksAdapter videoTracksAdapter = new VideoTracksAdapter(trackItems);
//                            getBinding().videoQuality.recycleview.setAdapter(videoTracksAdapter);
//
//                        } else {
//                            getBinding().videoDialog.setVisibility(View.GONE);
//                            ToastHandler.show(baseActivity.getResources().getString(R.string.no_video_available), baseActivity.getApplicationContext());
//
//                        }
//                    });
//
//                } else {
//                    getBinding().videoDialog.setVisibility(View.GONE);
//                    isDialogShowing = false;
//                    hideSoftKeyButton();
//                    ToastHandler.show(baseActivity.getResources().getString(R.string.no_tracks_available), baseActivity.getApplicationContext());
//                }
//            });
//        } else {
//            ToastHandler.show(baseActivity.getResources().getString(R.string.no_tracks_available), baseActivity.getApplicationContext());
//        }
//    }
//
//
//    private void playPauseControl() {
//
//        viewModel.playPauseControl().observe(this, aBoolean -> {
//            if (aBoolean != null && aBoolean) {
//                getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//
//            } else {
//                if (NetworkConnectivity.isOnline(baseActivity)) {
//                    getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_play));
//
//                } else {
//
//                    showDialog(getResources().getString(R.string.no_internet_connection));
//                }
//
//            }
//        });
//    }
//
//    int positionInPercentage = 0;
//
//    @Override
//    public void onProgressChanged(SeekBar seekbar, int progress,
//                                  boolean fromTouch) {
//
//        if (seekbar.getId() == R.id.seekBar1) {
//            Log.d("fgfgfgfgfg", progress + "");
//            WindowManager.LayoutParams layout = getActivity().getWindow().getAttributes();
//            layout.screenBrightness = progress / 100F;
//            getActivity().getWindow().setAttributes(layout);
//        } else if (seekbar.getId() == R.id.seekBar2) {
//            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
//        } else {
//
//            if (isLivePlayer) {
//            } else {
//                positionInPercentage = Math.round((seekbar.getProgress() * 100 / runningPlayer.getDuration()));
//                Log.d("Positionperc", positionInPercentage + "");
//
//                float leftMargin = seekbar.getWidth() * positionInPercentage / 100;
//
//                if (leftMargin < (seekbar.getWidth() + (4 * getBinding().currentTime.getPaddingLeft() - 90) - getBinding().currentTime.getWidth())) {
//                    //previewImage.translationX = leftMargin
//                    getBinding().imagePreview.setTranslationX(leftMargin);
//                }
//
//                try {
//
//                    if (fromTouch) {
//                        if (previewImagesHashMap != null) {
//                            Bitmap bitmap = previewImagesHashMap.get(String.valueOf(positionInPercentage));
//                            if (bitmap != null) {
//                                getBinding().imagePreview.setVisibility(View.VISIBLE);
//                                getBinding().imagePreview.setImageBitmap(bitmap);
//                                getBinding().imagePreview.bringToFront();
//                            }
//                        } else {
//                            getBinding().imagePreview.setVisibility(View.VISIBLE);
//                            getBinding().imagePreview.bringToFront();
//                        }
//                    }
//                } catch (Exception e) {
//
//                }
//            }
//            viewModel.sendSeekBarProgress(seekbar.getProgress()).observe(this, s -> getBinding().currentTime.setText(s));
//        }
//
//    }
//
//    private void checkPercentagePlayedOfVideo() {
//        isPlayerSurfaceClicked = false;
//        double currentPosition = runningPlayer.getCurrentPosition();
//        double totalDuration = runningPlayer.getDuration();
//        double percentagePlayed = ((currentPosition / totalDuration) * 100L);
//        if (percentagePlayed >= 98) {
//            if (creditEndTime < recapStartTime || creditEndTime < introStartTime) {
//
//            } else {
//                if (!isSkipCreditVisible) {
//                    isSkipCreditVisible = true;
//                    getBinding().progressBar.setVisibility(View.VISIBLE);
//                    objectAnimator = ObjectAnimator.ofInt(getBinding().progressBar, "progress", getBinding().progressBar.getProgress(), 100).setDuration(10000);
//                    objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                            int progress = (int) valueAnimator.getAnimatedValue();
//                            getBinding().progressBar.setProgress(progress);
//                        }
//                    });
//                    objectAnimator.start();
//                    getBinding().skipCredits.setText(labelCredit);
//                    getBinding().skipCredits.setVisibility(View.VISIBLE);
//
//
//                    hideSkipIntro();
//                }
//            }
//        }
//
//    }
//
//    private void hideSkipIntro() {
//        handler1.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                getBinding().skipCredits.setText("");
//                getBinding().skipCredits.setVisibility(View.GONE);
//                getBinding().progressBar.setVisibility(View.GONE);
//                if (objectAnimator != null) {
//                    objectAnimator.cancel();
//                    objectAnimator = null;
//                }
//                getBinding().progressBar.setProgress(0);
//                if (asset.getType() == MediaTypeConstant.getEpisode(getActivity())) {
//                    if (isUserGeneratedCredit) {
//                        getBinding().nextEpisode.setVisibility(View.GONE);
//                        getBinding().progressBar.setVisibility(View.GONE);
//                        //playNextEpisode();
//                    } else {
//                        if (creditEndTime < recapStartTime || creditEndTime < introStartTime) {
//
//                        } else {
//                            getBinding().progressBar.setVisibility(View.GONE);
//                            getBinding().nextEpisode.setVisibility(View.GONE);
////                            playNextEpisode();
//                        }
//                    }
//                }
//                if (!isPlayerSurfaceClicked) {
//                    playNextEpisode();
//                } else {
//                    getBinding().nextEpisode.setVisibility(View.VISIBLE);
//                }
//            }
//        }, 10000);
//    }
//
//
//    public boolean areAllControlsHiddenOrShown() {
//        return areAllControlsShown;
//    }
//
//
//    public void togglePlayerMediaControlsVisiblity() {
//        if (getBinding().playerMediaControls.getVisibility() != View.VISIBLE) {
//            showPlayerMediaControls();
//
//        } else {
//            hidePlayerMediaControls();
//        }
//    }
//
//    public void showPlayerMediaControls() {
//        if (getBinding().playerMediaControls.getVisibility() != View.VISIBLE) {
//            getBinding().playerMediaControls.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public boolean isDragGesture=false;
//
//    public void hideUIbeforDrag() {
//        isDragGesture = true;
//        hideRlUp();
//        hideIvSookaLogo();
//        showCurrentTime();
//        showTotalDuration();
//        hideFullscreen();
//        hideLlQualityAndSubtitle();
//        hideVolumeDialog();
//        hideBrightnessDialog();
//        hidePlayerMediaControls();
//    }
//
//    public void hidePlayerMediaControls() {
//        if (getBinding().playerMediaControls.getVisibility() == View.VISIBLE) {
//            getBinding().playerMediaControls.setVisibility(View.GONE);
//        }
//    }
//
//    public void showSeekBar() {
//        if (getBinding().seekBar.getVisibility() != View.VISIBLE) {
//            getBinding().seekBar.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void hideSeekBar() {
//        if (getBinding().seekBar.getVisibility() == View.VISIBLE) {
//            getBinding().seekBar.setVisibility(View.GONE);
//        }
//    }
//
//    public void hidePbar() {
//        getBinding().pBar.setVisibility(View.GONE);
//
//    }
//
//    public void showPbar() {
//        getBinding().pBar.setVisibility(View.VISIBLE);
//
//    }
//
//    public void showRlDown() {
//        if (getBinding().rlDown.getVisibility() != View.VISIBLE) {
//            getBinding().rlDown.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void hideRlDown() {
//        if (getBinding().rlDown.getVisibility() == View.VISIBLE) {
//            getBinding().rlDown.setVisibility(View.GONE);
//        }
//    }
//
//    public void makeRlDownInvisible() {
//        getBinding().rlDown.setVisibility(View.INVISIBLE);
//    }
//
//    public void showLiveTxt() {
//        if (getBinding().liveTxt.getVisibility() != View.VISIBLE) {
//            getBinding().liveTxt.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void hideLiveTxt() {
//        if (getBinding().liveTxt.getVisibility() == View.VISIBLE) {
//            getBinding().liveTxt.setVisibility(View.GONE);
//        }
//    }
//
//    public void makeLiveTxtInvisible() {
//        getBinding().liveTxt.setVisibility(View.INVISIBLE);
//    }
//
//
//    public void hidePlayerAllControls() {
//        if (getBinding().rlUp.getVisibility() == View.VISIBLE) {
//            hideRlUp();
//        }
//        if (getBinding().ivSookaLogo.getVisibility() == View.VISIBLE) {
//            hideIvSookaLogo();
//        }
//        if (getBinding().currentTime.getVisibility() == View.VISIBLE) {
//            hideCurrentTime();
//        }
//        if (getBinding().totalDuration.getVisibility() == View.VISIBLE) {
//            hideTotalDuration();
//        }
//        if (getBinding().fullscreen.getVisibility() == View.VISIBLE) {
//            hideFullscreen();
//        }
//        if (getBinding().llQualityAndSubtitile.getVisibility() == View.VISIBLE) {
//            hideLlQualityAndSubtitle();
//        }
//        if (getBinding().brightnessDialog.getVisibility() == View.VISIBLE) {
//            hideBrightnessDialog();
//        }
//        if (getBinding().volumeDialog.getVisibility() == View.VISIBLE) {
//            hideVolumeDialog();
//        }
//        if (getBinding().playerMediaControls.getVisibility() == View.VISIBLE) {
//            showMediaPlayerControls();
//        }
//        changePlayerAllControlsVisiblityFlag(false);
//    }
//
//    public void showPlayerAllControls() {
//        if (getBinding().rlUp.getVisibility() != View.VISIBLE) {
//            showRlUp();
//        }
//        if (getBinding().ivSookaLogo.getVisibility() != View.VISIBLE) {
//            showIvSookaLogo();
//        }
//        if (getBinding().currentTime.getVisibility() != View.VISIBLE) {
//            showCurrentTime();
//        }
//        if (getBinding().totalDuration.getVisibility() != View.VISIBLE) {
//            if (!adRunning) {
//                showTotalDuration();
//            }
//            else{
//                hideTotalDuration();
//            }
//        }
//        if (getBinding().slash.getVisibility() != View.VISIBLE) {
//            if (!adRunning) {
//                showSlash();
//            }
//            else{
//                hideSlash();
//            }
//        }
//        if (getBinding().fullscreen.getVisibility() != View.VISIBLE) {
//            showFullscreen();
//        }
//        if (getBinding().llQualityAndSubtitile.getVisibility() != View.VISIBLE) {
//            showLlQualityAndSubtitle();
//        }
//        if (getBinding().playerMediaControls.getVisibility() != View.VISIBLE) {
//            showMediaPlayerControls();
//        }
//        changePlayerAllControlsVisiblityFlag(true);
//    }
//
//    public boolean isSeekBarInteraction = false;
//
//    public void performUItransformationOnSeekBarInteraction(boolean isInteracting) {
//        isSeekBarInteraction = isInteracting;
//        if (isInteracting) {
//            hideRlUp();
//            hideIvSookaLogo();
//            showCurrentTime();
//            showTotalDuration();
//            hideFullscreen();
//            hideLlQualityAndSubtitle();
//            hideVolumeDialog();
//            hideBrightnessDialog();
//            hidePlayerMediaControls();
//        }
//        else{
//            showPlayerAllControls();
//        }
//
//    }
//
//    public void performUITransformationOnHorizontalDrag() {
//        if (getBinding().rlUp.getVisibility() == View.VISIBLE) {
//            hideRlUp();
//        }
//        if (getBinding().ivSookaLogo.getVisibility() != View.VISIBLE) {
//            hideIvSookaLogo();
//        }
//        if (getBinding().currentTime.getVisibility() != View.VISIBLE) {
//            hideCurrentTime();
//        }
//        if (getBinding().totalDuration.getVisibility() != View.VISIBLE) {
//            hideTotalDuration();
//        }
//        if (getBinding().fullscreen.getVisibility() == View.VISIBLE) {
//            hideFullscreen();
//        }
//        if (getBinding().llQualityAndSubtitile.getVisibility() == View.VISIBLE) {
//            hideLlQualityAndSubtitle();
//        }
//        if (getBinding().volumeDialog.getVisibility() == View.VISIBLE) {
//            hideVolumeDialog();
//        }
//        if (getBinding().brightnessDialog.getVisibility() == View.VISIBLE) {
//            hideBrightnessDialog();
//        }
//        hidePlayerMediaControls();
//        if (getBinding().seekBar.getVisibility() != View.VISIBLE) {
//            getBinding().seekBar.setVisibility(View.VISIBLE);
//        }
//
//    }
//
//
//    //Show individual controls
//    public void showRlUp() {
//        if (getBinding().rlUp.getVisibility() != View.VISIBLE) {
//            getBinding().rlUp.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showIvSookaLogo() {
//        if (getBinding().ivSookaLogo.getVisibility() != View.VISIBLE) {
//            getBinding().ivSookaLogo.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showCurrentTime() {
//        if (getBinding().currentTime.getVisibility() != View.VISIBLE) {
//            getBinding().currentTime.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showTotalDuration() {
//        if (getBinding().totalDuration.getVisibility() != View.VISIBLE) {
//            getBinding().totalDuration.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showFullscreen() {
//        if (getBinding().fullscreen.getVisibility() != View.VISIBLE) {
//            getBinding().fullscreen.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showVolumeDialog() {
//        if (getBinding().volumeDialog.getVisibility() != View.VISIBLE) {
//            getBinding().volumeDialog.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showBrightnessDialog() {
//        if (getBinding().brightnessDialog.getVisibility() != View.VISIBLE) {
//            getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showMediaPlayerControls() {
//        if (getBinding().playerMediaControls.getVisibility() != View.VISIBLE) {
//            getBinding().playerMediaControls.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public void showLlQualityAndSubtitle() {
//        Log.i("TOUCH_EVENT", "show_qualitySubtitle");
//        if (getBinding().llQualityAndSubtitile.getVisibility() != View.VISIBLE) {
//            getBinding().llQualityAndSubtitile.setVisibility(View.VISIBLE);
//        }
//    }
//
//    //Hide individual controls
//
//    public void hideRlUp() {
//        if (getBinding().rlUp.getVisibility() == View.VISIBLE) {
//            getBinding().rlUp.setVisibility(View.GONE);
//        }
//    }
//
//    public void makeRlUpInvisible() {
//        getBinding().rlUp.setVisibility(View.INVISIBLE);
//    }
//
//    public void hideIvSookaLogo() {
//        if (getBinding().ivSookaLogo.getVisibility() == View.VISIBLE) {
//            getBinding().ivSookaLogo.setVisibility(View.GONE);
//        }
//    }
//
//    public void hideCurrentTime() {
//        if (getBinding().currentTime.getVisibility() == View.VISIBLE) {
//            getBinding().currentTime.setVisibility(View.GONE);
//        }
//    }
//
//    public void hideTotalDuration() {
//        if (getBinding().totalDuration.getVisibility() == View.VISIBLE) {
//            getBinding().totalDuration.setVisibility(View.GONE);
//        }
//    }
//
//    public void hideFullscreen() {
//        if (getBinding().fullscreen.getVisibility() == View.VISIBLE) {
//            getBinding().fullscreen.setVisibility(View.GONE);
//        }
//    }
//
//    public void hideBrightnessDialog() {
//        if (getBinding().brightnessDialog.getVisibility() == View.VISIBLE) {
//            getBinding().brightnessDialog.setVisibility(View.GONE);
//        }
//    }
//
//    public void hideMediaPlayerControls() {
//        if (getBinding().playerMediaControls.getVisibility() == View.VISIBLE) {
//            getBinding().playerMediaControls.setVisibility(View.GONE);
//        }
//    }
//
//    public void hideLlQualityAndSubtitle() {
//        if (getBinding().llQualityAndSubtitile.getVisibility() == View.VISIBLE) {
//            getBinding().llQualityAndSubtitile.setVisibility(View.GONE);
//        }
//    }
//
//    public void hideVolumeDialog() {
//        if (getBinding().volumeDialog.getVisibility() == View.VISIBLE) {
//            getBinding().volumeDialog.setVisibility(View.GONE);
//        }
//    }
//
//    public void changePlayerAllControlsVisiblityFlag(boolean areAllControlsVisible) {
//        if (areAllControlsVisible != areAllControlsShown) {
//            areAllControlsShown = areAllControlsVisible;
//        }
//    }
//
//    public boolean areAllControlsShown = false;
//
//
//    @Override
//    public void onStartTrackingTouch(final SeekBar seekBar) {
//        performUItransformationOnSeekBarInteraction(true);
//        if (seekBar.getId() == R.id.seekBar1) {
//
//        } else if (seekBar.getId() == R.id.seekBar2) {
//
//        } else {
//
//            viewModel.removeCallBack();
//            if (timer) {
//                timeHandler.removeCallbacks(myRunnable);
//            }
//
//            final LiveData<Boolean> booleanLiveData = viewModel.getPlayerProgress();
//            booleanLiveData.observe(baseActivity, aBoolean -> {
//                booleanLiveData.removeObservers(baseActivity);
//                if (booleanLiveData.hasObservers()) return;
//                if (aBoolean != null && aBoolean) {
//                    hidePbar();
//                }
//            });
//
//            getBinding().skipCredits.setText("");
//            getBinding().skipCredits.setVisibility(View.GONE);
//            getBinding().progressBar.setVisibility(View.GONE);
//            if (objectAnimator != null) {
//                objectAnimator.cancel();
//                objectAnimator = null;
//            }
//            getBinding().progressBar.setProgress(0);
//
//
//        }
//
//
//    }
//
//    @Override
//    public void onStopTrackingTouch(SeekBar seekBar) {
//        if (seekBar.getId() == R.id.seekBar1) {
//
//        } else if (seekBar.getId() == R.id.seekBar2) {
//
//        } else {
//            getBinding().imagePreview.setVisibility(View.GONE);
//            isSkipCreditVisible = false;
//            showPbar();
//            viewModel.getPlayerView(seekBar);
//            callHandler();
//        }
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d("PlayerPauseCalled", "OnResumeTrue");
//        if (getBaseActivity() != null) {
//            IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//            getBaseActivity().registerReceiver(networkReceiver, intentFilter);
//            IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
//            getBaseActivity().registerReceiver(headsetRecicer, receiverFilter);
//            Objects.requireNonNull(getActivity()).registerReceiver(receiver, filter);
//            setConnectivityListener(this);
//
//            IntentFilter filter = new IntentFilter();
//            filter.addAction("com.dialog.dialoggo.Alarm.MyReceiver");
//            getActivity().registerReceiver(myReceiver, filter);
//
//            mDisplayManager.registerDisplayListener(mDisplayListener, null);
//            if (mDisplayManager != null) {
//                isHDMI(mDisplayManager);
//            }
//
//        }
//        resumePlayer();
//    }
//
//    private void isHDMI(DisplayManager mDisplayManager) {
//        Display display[] = mDisplayManager.getDisplays();
//        try {
//            if (display.length > 0) {
//                for (int i = 0; i < display.length; i++) {
//                    Log.w("addedDisplays", display[i].getName());
//                    if (display[i].getName().contains("HDMI")) {
//                        isHdmiConnected = true;
//                        if (runningPlayer != null) {
//                            runningPlayer.stop();
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//
//        }
//    }
//
//    boolean isHdmiConnected = false;
//    private final DisplayManager.DisplayListener mDisplayListener =
//            new DisplayManager.DisplayListener() {
//                @Override
//                public void onDisplayAdded(int displayId) {
//                    Log.w("addedDisplays 4--", displayId + "");
//                    isHdmiConnected = true;
//                    if (runningPlayer != null) {
//                        runningPlayer.stop();
//                    }
//
//                }
//
//                @Override
//                public void onDisplayChanged(int displayId) {
//                    Log.w("addedDisplays 3--", displayId + "");
//
//                }
//
//                @Override
//                public void onDisplayRemoved(int displayId) {
//                    Log.w("addedDisplays 2--", displayId + "");
//                    isHdmiConnected = false;
//                    try {
//                        cancelTimer();
//                        getBinding().linearAutoPlayLayout.setVisibility(View.GONE);
//                        getUrl(playerURL, asset, playerProgress, isLivePlayer, "", railList, programAsset);
//                    } catch (Exception e) {
//
//                    }
//                }
//            };
//
//
//    private void resumePlayer() {
//        Log.d("PlayerPauseCalled", "OnResumeTrue");
//        if (viewModel != null) {
//            if (isPlayerStart) {
//                if (NetworkConnectivity.isOnline(baseActivity)) {
//                    viewModel.getResumeState().observe(this, aBoolean -> {
//                        if (aBoolean != null && aBoolean) {
//                            if (runningPlayer != null) {
//                                hidePlayerWigetOnResume();
//                                getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//                            }
//                        }
//                    });
//                }
//
//            } else {
//                Log.d("PlayerPauseCalled", "else");
//                getUrl(playerURL, playerAsset, playerProgress, isLivePlayer, "", railList, programAsset);
//                if (adRunning) {
//                    getBinding().rl1.setVisibility(View.GONE);
//                    getBinding().volumeDialog.setVisibility(View.GONE);
//                    getBinding().brightnessDialog.setVisibility(View.GONE);
//                    getBinding().listViewSettings.setVisibility(View.GONE);
//                }
//            }
//        }
//
//    }
//
//    public void setConnectivityListener(NetworkChangeReceiver.ConnectivityReceiverListener listener) {
//        NetworkChangeReceiver.connectivityReceiverListener = listener;
//    }
//
//    private void hidePlayerWigetOnResume() {
//        getBinding().rl1.setVisibility(View.GONE);
//        hideVolumeDialog();
//        hideBrightnessDialog();
//        getBinding().listViewSettings.setVisibility(View.GONE);
//        showPbar();
//        getBinding().loading.setVisibility(View.VISIBLE);
//
//        Log.e("hidePlayerWigetOnResume", "hidePlayerWigetOnResume");
//
//        Handler mHandler = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                hidePbar();
//                getBinding().loading.setVisibility(View.GONE);
//
//                if (lockEnable) {
//                    getBinding().rl1.setVisibility(View.GONE);
//                    getBinding().listViewSettings.setVisibility(View.GONE);
//                    getBinding().volumeDialog.setVisibility(View.GONE);
//                    getBinding().brightnessDialog.setVisibility(View.GONE);
//                } else {
//                    getBinding().rl1.setVisibility(View.VISIBLE);
//                    getBinding().listViewSettings.setVisibility(View.VISIBLE);
//                    getBinding().volumeDialog.setVisibility(View.VISIBLE);
//                    getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//                }
//            }
//        }, 4000);
//
//
//    }
//
//    private void checkSeasonAndEpisodeNumber(Map<String, Value> metas) {
//        seasonNumber = AssetContent.getSpecificSeason(metas);
//        episodeNumber = AssetContent.getSpecificEpisode(metas);
//        Log.d("EpisodeNumberIs", episodeNumber + "");
//        Log.d("SeasonNumberIs", seasonNumber + "");
//    }
//
//    @SuppressLint("ClickableViewAccessibility")
//    private void setTouchFalse() {
//        getBinding().rl1.setOnTouchListener((v, event) -> false);
//        getBinding().rl.setOnTouchListener((v, event) -> false);
//        getBinding().rl1.setClickable(false);
//        getBinding().rl.setClickable(false);
//        getBinding().rl1.setFocusable(false);
//        getBinding().rl.setFocusable(false);
//
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//
//        Log.d("PlayerPauseCalled", "Pause");
//
//        if (getActivity() != null) {
//            PowerManager powerManager = (PowerManager) getActivity().getSystemService(POWER_SERVICE);
//            boolean isScreenOn = powerManager.isScreenOn();
//            if (runningPlayer != null) {
//                runningPlayer.pause();
//                runningPlayer.onApplicationPaused();
//            }
//        }
//        if (receiver != null) {
//            Objects.requireNonNull(getActivity()).unregisterReceiver(receiver);
//            NetworkChangeReceiver.connectivityReceiverListener = null;
//        }
//        this.baseActivity.unregisterReceiver(networkReceiver);
//        this.baseActivity.unregisterReceiver(headsetRecicer);
//
//        try {
//            if (mDisplayListener != null) {
//                mDisplayManager.unregisterDisplayListener(mDisplayListener);
//            }
//        } catch (Exception ignored) {
//
//        }
//    }
//
//
//    private void pausePlayer() {
//        Log.d("PlayerPauseCalled", "Enter");
//        isPause = true;
//        if (viewModel != null) {
//            if (isPlayerStart) {
//                viewModel.getPausestate().observe(this, aBoolean -> {
//                    if (aBoolean != null && aBoolean) {
//                        getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_play));
//
//                    }
//                });
//
//            } else {
//
//                PlayerRepository.getInstance().releasePlayer();
//            }
//
//        }
//    }
//
//
//    @Override
//    public void onCallStateRinging() {
//        pausePlayer();
//
//    }
//
//    @Override
//    public void onCallStateIdle() {
//    }
//
//    @Override
//    public void windowFocusChange(boolean hasFocus) {
//        if (hasFocus) {
//            if (viewModel != null) {
//                viewModel.getPlayerObject().observe(DTPlayer.this, player -> {
//                    if (player != null) {
//                        if (!player.isPlaying() && isPause) {
//                            isPause = false;
//                            if (player != null) {
//                                player.play();
//                                getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//                            }
//
//                        }
//                    }
//                });
//            }
//        } else {
//            if (!isDialogShowing) {
//                pausePlayer();
//            }
//        }
//    }
//
//    private void pausePlayerOnInternetGone(final Player player) {
//        new Handler().postDelayed(() -> {
//            if (player != null) {
//                player.pause();
//                notPlayContentWithoutInternet();
//            }
//        }, 10000);
//
//    }
//
//    private void playContentOnReconnect() {
//        if (assetType == MediaTypeConstant.getLinear(baseActivity)) {
//
//            getBinding().playericon.setVisibility(View.GONE);
//            hidePbar();
//            getBinding().rl1.setVisibility(View.VISIBLE);
//            getBinding().playButton.setVisibility(View.VISIBLE);
//            getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//            getBinding().seekBar.setVisibility(View.VISIBLE);
//            getBinding().currentTime.setVisibility(View.VISIBLE);
//            getBinding().totalDuration.setVisibility(View.VISIBLE);
//            getBinding().fullscreen.setVisibility(View.GONE);
//            getBinding().forward.setVisibility(View.GONE);
//            getBinding().backward.setVisibility(View.GONE);
//            getBinding().slash.setVisibility(View.VISIBLE);
//            getBinding().quality.setVisibility(View.GONE);
//            getBinding().volumeDialog.setVisibility(View.VISIBLE);
//            getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//
//
//        } else {
//            getBinding().playericon.setVisibility(View.GONE);
//            hidePbar();
//            getBinding().rl1.setVisibility(View.VISIBLE);
//            getBinding().playButton.setVisibility(View.VISIBLE);
//            getBinding().playButton.setImageDrawable(ContextCompat.getDrawable(baseActivity, R.drawable.ic_pause));
//            getBinding().seekBar.setVisibility(View.VISIBLE);
//            getBinding().currentTime.setVisibility(View.VISIBLE);
//            getBinding().totalDuration.setVisibility(View.VISIBLE);
//            getBinding().fullscreen.setVisibility(View.GONE);
//            getBinding().forward.setVisibility(View.VISIBLE);
//            getBinding().backward.setVisibility(View.VISIBLE);
//            getBinding().slash.setVisibility(View.VISIBLE);
//            getBinding().quality.setVisibility(View.VISIBLE);
//            getBinding().volumeDialog.setVisibility(View.VISIBLE);
//            getBinding().brightnessDialog.setVisibility(View.VISIBLE);
//
//        }
//
//        if (isCaption || isAudioTracks) {
//            getBinding().subtitleAudio.setVisibility(View.VISIBLE);
//        } else {
//            getBinding().subtitleAudio.setVisibility(View.GONE);
//        }
//
//
//    }
//
//    private String stringForTime(long timeMs) {
//        StringBuilder formatBuilder = new StringBuilder();
//        Formatter formatter = new Formatter(formatBuilder, Locale.getDefault());
//
//        long totalSeconds = (timeMs + 500) / 1000;
//        long seconds = totalSeconds % 60;
//        long minutes = (totalSeconds / 60) % 60;
//        long hours = totalSeconds / 3600;
//        formatBuilder.setLength(0);
//        return hours > 0 ? formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString()
//                : formatter.format("%02d:%02d", minutes, seconds).toString();
//    }
//
//    private void showAlertDialog(String msg, String positiveButtonText, String negativeButtonText) {
//        FragmentManager fm = getFragmentManager();
//        AlertDialogFragment alertDialog = AlertDialogFragment.newInstance(getResources().getString(R.string.dialog), msg, positiveButtonText, negativeButtonText);
//        alertDialog.setAlertDialogCallBack(this);
//        if (fm != null)
//            alertDialog.show(fm, AppLevelConstants.TAG_FRAGMENT_ALERT);
//    }
//
//    private void showDialog(String message) {
//        FragmentManager fm = getFragmentManager();
//        AlertDialogSingleButtonFragment alertDialog = AlertDialogSingleButtonFragment.newInstance(getResources().getString(R.string.dialog), message, getResources().getString(R.string.ok));
//        alertDialog.setCancelable(false);
//        alertDialog.setAlertDialogCallBack(this);
//        if (fm != null)
//            alertDialog.show(fm, AppLevelConstants.TAG_FRAGMENT_ALERT);
//    }
//
//    @Override
//    public void onFinishDialog() {
//
//        if (isPlayerIconClick) {
//            isPlayerIconClick = false;
//            new ActivityLauncher(baseActivity).loginActivity(baseActivity, LoginActivity.class, 0, "");
//        } else if (isError) {
//            isError = false;
//            getActivity().onBackPressed();
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//
//        if (baseActivity != null) {
//            baseActivity = null;
//        }
//        if (cTimer != null) {
//            cTimer.cancel();
//        }
//        KsPreferenceKey.getInstance(getActivity()).setCatchupValue(false);
//        PlayerRepository.getInstance().removeCallBacks();
//
//    }
//
//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.quality:
//                chooseVideoquality();
//                break;
//            case R.id.audio: {
//                addAudioToPlayer();
//                callHandler();
//            }
//            break;
//            case R.id.cancel:
//                dialog.cancel();
//                isDialogShowing = false;
//                break;
//        }
//    }
//
//    @Override
//    public void onAudioFocusChange(int focusChange) {
//
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        try {
//            if (PlayerRepository.getInstance() != null) {
//                PlayerRepository.getInstance().destroCallBacks();
//            }
//            if (isAdsRunning) {
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdMetric(ConvivaSdkConstants.PLAYBACK.PLAYER_STATE, ConvivaSdkConstants.PlayerState.STOPPED);
//                ConvivaManager.getConvivaAdAnalytics(baseActivity).reportAdEnded();
//                ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportAdBreakEnded();
//                ConvivaManager.removeConvivaAdsSession();
//            }
//            ConvivaManager.convivaPlayerStoppedReportRequest();
//            ConvivaManager.getConvivaVideoAnalytics(baseActivity).reportPlaybackEnded();
//            ConvivaManager.removeConvivaSession();
//            if (powerManager != null) {
//                if (wakeLock != null) {
//                    wakeLock.release();
//                }
//                TelephonyManager mgr = (TelephonyManager) baseActivity.getSystemService(TELEPHONY_SERVICE);
//                if (mgr != null) {
//                    mgr.listen(PhoneStateListenerHelper.getInstance(this), PhoneStateListener.LISTEN_NONE);
//                }
//            }
//        } catch (Exception e) {
//            PrintLogging.printLog("Exception", "", "" + e);
//        }
//        if (mAudioManager != null)
//            mAudioManager.abandonAudioFocus(this);
//    }
//
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        try {
//            getActivity().unregisterReceiver(myReceiver);
//        } catch (IllegalArgumentException e) {
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    private void splitStartTime(String startTime) {
//
//        StringTokenizer tokens = new StringTokenizer(startTime, " ");
//        String date = tokens.nextToken();// this will contain "Fruit"
//        time = tokens.nextToken();
//
//        splitMinute(time);
//
//    }
//
//    private void splitMinute(String time) {
//        StringTokenizer tokens = new StringTokenizer(time, ":");
//        hour = tokens.nextToken();
//        minute = tokens.nextToken();
//
//        PrintLogging.printLog("", "hoursandMinuteIs" + hour + minute);
//    }
//
//
//    static class ViewHolder1 extends RecyclerView.ViewHolder {
//
//        RelativeLayout tracksQuality;
//        ImageView tick, imgQuality;
//        private TextView qualityText, description;
//        private AppCompatRadioButton playbackQualityRadio;
//        private Button closeButton;
//        private RelativeLayout layout;
//
//        private ViewHolder1(View itemView) {
//            super(itemView);
//            // tracksQuality = itemView.findViewById(R.id.tracksQuality);
//            //   playbackQualityRadio = itemView.findViewById(R.id.playbackQualityRadio);
//            qualityText = itemView.findViewById(R.id.quality_text);
//            description = itemView.findViewById(R.id.description);
//            tick = itemView.findViewById(R.id.tick);
//            imgQuality = itemView.findViewById(R.id.img);
//            layout = itemView.findViewById(R.id.video_quality__layout);
//        }
//    }
//
//    static class ViewHolder3 extends RecyclerView.ViewHolder {
//
//        final TextView playbackCaption;
//        final RelativeLayout tracksCaption;
//        final ImageView tick;
//
//
//        private ViewHolder3(View itemView) {
//            super(itemView);
//            playbackCaption = itemView.findViewById(R.id.playbackCaption);
//            tracksCaption = itemView.findViewById(R.id.tracksCaption);
//            tick = itemView.findViewById(R.id.tick);
//
//        }
//    }
//
//    static class ViewHolder2 extends RecyclerView.ViewHolder {
//
//        final TextView audioTracks;
//        final RelativeLayout audio;
//        final ImageView tick;
//
//
//        private ViewHolder2(View itemView) {
//            super(itemView);
//            audioTracks = itemView.findViewById(R.id.audioTracks);
//            audio = itemView.findViewById(R.id.audio);
//            tick = itemView.findViewById(R.id.tick);
//
//        }
//    }
//
//    class VideoTracksAdapter extends RecyclerView.Adapter<ViewHolder1> {
//        final ArrayList<TrackItem> tracks;
//        private VideoTracksAdapter(ArrayList<TrackItem> videoTracks) {
//            this.tracks = videoTracks;
//
//        }
//
//        @NonNull
//        @Override
//        public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playback_quality, parent, false);
//            return new ViewHolder1(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull final ViewHolder1 holder, final int position) {
//            if (trackItemList.get(position).isSelected()) {
//
//                if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.LOW)) {
//                    holder.imgQuality.setBackgroundResource(R.drawable.ic_low_quality_green);
//
//                } else if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.MEDIUM)) {
//                    holder.imgQuality.setBackgroundResource(R.drawable.ic_medium_quality_green);
//
//                } else if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.HIGH)) {
//                    holder.imgQuality.setBackgroundResource(R.drawable.ic_high_quality_green);
//
//                }
//                holder.qualityText.setTextColor(getResources().getColor(R.color.turquoise_green));
//            } else {
//                if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.LOW)) {
//                    holder.imgQuality.setBackgroundResource(R.drawable.ic_low_quality);
//
//                } else if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.MEDIUM)) {
//                    holder.imgQuality.setBackgroundResource(R.drawable.ic_medium_quality);
//
//                } else if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.HIGH)) {
//                    holder.imgQuality.setBackgroundResource(R.drawable.ic_video_quality);
//
//                }
//                holder.qualityText.setTextColor(getResources().getColor(R.color.white));
//            }
//            holder.qualityText.setText(tracks.get(position).getTrackName());
//            holder.layout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int index = trackItemList.indexOf(new TrackItem("", "", true));
//                    getBinding().quality.setText(trackItemList.get(position).getTrackName());
//                    if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.LOW)) {
//                        getBinding().quality.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_low_quality, 0, 0, 0);
//                    } else if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.MEDIUM)) {
//                        getBinding().quality.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_medium_quality, 0, 0, 0);
//                    } else if (trackItemList.get(position).getTrackName().equalsIgnoreCase(AppLevelConstants.HIGH)) {
//                        getBinding().quality.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_video_quality, 0, 0, 0);
//                    }
//
//                    if (index == -1) {
//
//                        trackItemList.get(position).setSelected(true);
//                        trackName = trackItemList.get(position).getTrackName();
//                        getBinding().videoDialog.setVisibility(View.GONE);
//                        hideSoftKeyButton();
//                        showPbar();
//                        isDialogShowing = false;
//                        final LiveData<Boolean> booleanLiveData = viewModel.changeTrack(trackItemList.get(position).getTrackName());
//                        booleanLiveData.removeObservers(getActivity());
//                        booleanLiveData.observe(getActivity(), aBoolean -> {
//                            if (aBoolean != null && aBoolean) {
//                                new Handler().postDelayed(() -> getBinding().pBar.setVisibility(View.GONE), 1000);
//                            }
//                        });
//                    } else {
//                        if (trackItemList.get(position).getTrackName() == trackName) {
//                            getBinding().videoDialog.setVisibility(View.GONE);
//                            hideSoftKeyButton();
//                        } else {
//                            trackItemList.get(index).setSelected(false);
//                            trackItemList.get(position).setSelected(true);
//                            trackName = trackItemList.get(position).getTrackName();
//
//                            getBinding().videoDialog.setVisibility(View.GONE);
//                            hideSoftKeyButton();
//                            showPbar();
//                            isDialogShowing = false;
//                            final LiveData<Boolean> booleanLiveData = viewModel.changeTrack(trackItemList.get(position).getTrackName());
//                            booleanLiveData.removeObservers(getActivity());
//                            booleanLiveData.observe(getActivity(), aBoolean -> {
//                                if (aBoolean != null && aBoolean) {
//                                    new Handler().postDelayed(() -> getBinding().pBar.setVisibility(View.GONE), 1000);
//                                }
//                            });
//                        }
//
//
//                    }
//                    notifyDataSetChanged();
//
//                }
//            });
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return trackItemList.size();
//        }
//    }
//
//    int captionItemClick = 0;
//
//    class CaptionAdapter extends RecyclerView.Adapter<ViewHolder3> {
//        final TrackItem[] tracks;
//        int finalInde;
//
//        private CaptionAdapter(TrackItem[] videoTracks) {
//            this.tracks = videoTracks;
//
//        }
//
//        @NonNull
//        @Override
//        public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playback_caption, parent, false);
//
//            return new ViewHolder3(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull final ViewHolder3 holder, final int position) {
//            int index = 0;
//            try {
//
//
//                if (captionList[position].isSelected()) {
//                    index = position;
//                    //  holder.playbackCaption.setTextColor(getResources().getColor(R.color.green));
//                    //  holder.tick.setBackgroundResource(R.drawable.tick);
//                } else {
//                    // holder.playbackCaption.setTextColor(getResources().getColor(R.color.heather));
//                    // holder.tick.setBackgroundResource(0);
//                    //viewHolder.notificationItemBinding.titleText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
//                }
//                holder.playbackCaption.setText(captionList[position].getTrackName());
//
//                finalInde = index;
//                holder.tracksCaption.setOnClickListener(view -> {
//                    captionItemClick = 1;
//                    captionList[finalInde].setSelected(false);
//                    captionList[position].setSelected(true);
//                    captionName = captionList[position].getTrackName();
//                    viewModel.changeTextTrack(captionList[position].getUniqueId());
//                    getBinding().audioDialog.setVisibility(View.GONE);
//                    getBinding().skipIntro.setClickable(true);
//                    getBinding().skipCredits.setClickable(true);
//                    getBinding().skipRecap.setClickable(true);
//                    // dialogQuality.cancel();
//                    hideSoftKeyButton();
//                    notifyDataSetChanged();
//                });
//
//                Log.w("subtitleS", tracks[position].getTrackName() + "" + new KsPreferenceKey(baseActivity).getSubTitleLangKey() + "-----" + captionItemClick);
//                if (captionItemClick == 0) {
//                    Log.w("subtitleS 2", tracks[position].getTrackName() + "" + new KsPreferenceKey(baseActivity).getSubTitleLangKey() + "-----" + captionItemClick);
//                    // Log.w("colorChange 2",tracks[position].getTrackName()+"  "+new KsPreferenceKey(baseActivity).getAudioLangKey());
//                    if (new KsPreferenceKey(baseActivity).getSubtitleLanguageIndex() > -1 && !new KsPreferenceKey(baseActivity).getSubTitleLangKey().equalsIgnoreCase("")) {
//                        Log.w("subtitleS 3", tracks[position].getTrackName() + "" + new KsPreferenceKey(baseActivity).getSubTitleLangKey() + "-----" + captionItemClick);
//                        if (tracks[position].getTrackName().trim().equalsIgnoreCase(new KsPreferenceKey(baseActivity).getSubTitleLangKey().trim())) {
//                            holder.playbackCaption.setTextColor(getResources().getColor(R.color.green));
//                        } else {
//                            holder.playbackCaption.setTextColor(getResources().getColor(R.color.heather));
//                        }
//                    }
//                } else {
//                    if (captionList[position].getTrackName().equalsIgnoreCase(captionName)) {
//                        holder.playbackCaption.setTextColor(getResources().getColor(R.color.green));
//                    } else {
//                        holder.playbackCaption.setTextColor(getResources().getColor(R.color.heather));
//                    }
//                }
//            } catch (Exception ignored) {
//
//            }
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return tracks.length;
//        }
//    }
//
//    int audioItemClick = 0;
//
//    class AudioAdapter extends RecyclerView.Adapter<ViewHolder2> {
//        final TrackItem[] tracks;
//
//        private AudioAdapter(TrackItem[] audioTracks) {
//            this.tracks = audioTracks;
//
//        }
//
//        @NonNull
//        @Override
//        public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playback_audio, parent, false);
//
//            return new ViewHolder2(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull final ViewHolder2 holder, final int position) {
//            int index = 0;
//            try {
//                if (tracks[position] != null) {
//                    holder.audioTracks.setText(tracks[position].getTrackName());
//
//                    if (tracks[position].isSelected()) {
//                        index = position;
//                        // holder.tick.setBackgroundResource(R.drawable.tick);
//                    } else {
//                        //  holder.tick.setBackgroundResource(0);
//                        //viewHolder.notificationItemBinding.titleText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
//                    }
//                    int finalIndex = index;
//                    holder.audio.setOnClickListener(view -> {
//                        audioItemClick = 1;
//                        tracks[finalIndex].setSelected(false);
//                        tracks[position].setSelected(true);
//                        audioTrackName = tracks[position].getTrackName();
//                        //   holder.tick.setVisibility(View.VISIBLE);
//                        viewModel.changeAudioTrack(tracks[position].getUniqueId());
//                        //  dialogQuality.cancel();
//                        hideSoftKeyButton();
//                        notifyDataSetChanged();
//
//
//                    });
//
//
//                    Log.w("colorChange", tracks[position].getTrackDescription() + "" + new KsPreferenceKey(baseActivity).getAudioLangKey());
//                    if (audioItemClick == 0) {
//                        // Log.w("colorChange 2",tracks[position].getTrackName()+"  "+new KsPreferenceKey(baseActivity).getAudioLangKey());
//                        if (new KsPreferenceKey(baseActivity).getAudioLanguageIndex() > -1 && !new KsPreferenceKey(baseActivity).getAudioLangKey().equalsIgnoreCase("")) {
//                            //  Log.w("colorChange 3",tracks[position].getTrackName()+"  "+new KsPreferenceKey(baseActivity).getAudioLangKey());
//                            if (tracks[position].getTrackDescription().trim().equalsIgnoreCase(new KsPreferenceKey(baseActivity).getAudioLangKey().trim())) {
//                                Log.w("colorChange 5", tracks[position].getTrackName() + "  " + new KsPreferenceKey(baseActivity).getAudioLangKey());
//                                holder.audioTracks.setTextColor(getResources().getColor(R.color.green));
//                            } else {
//                                Log.w("colorChange 6", tracks[position].getTrackName() + "  " + new KsPreferenceKey(baseActivity).getAudioLangKey());
//                                holder.audioTracks.setTextColor(getResources().getColor(R.color.heather));
//                            }
//                        } else {
//                            Log.w("colorChange 4", tracks[position].getTrackName() + "  " + new KsPreferenceKey(baseActivity).getAudioLangKey());
//                            if (tracks[position].getTrackName().equalsIgnoreCase(audioTrackName)) {
//                                holder.audioTracks.setTextColor(getResources().getColor(R.color.green));
//                            } else {
//                                holder.audioTracks.setTextColor(getResources().getColor(R.color.heather));
//                            }
//                        }
//
//                    } else {
//                        if (tracks[position].getTrackName().equalsIgnoreCase(audioTrackName)) {
//                            holder.audioTracks.setTextColor(getResources().getColor(R.color.green));
//                        } else {
//                            holder.audioTracks.setTextColor(getResources().getColor(R.color.heather));
//                        }
//                    }
//
//                }
//            } catch (Exception ignored) {
//
//            }
//
//
//        }
//
//        private String changeLanguage(String language) {
//
//            Locale streamLang = new Locale(language);
//            Locale locale = new Locale("en");
//            //streamLang.getISO3Language();
//
//            return streamLang.getDisplayLanguage(locale);
//        }
//
//        @Override
//        public int getItemCount() {
//            return tracks.length;
//        }
//    }
//
//    public void getVolume(String volume) {
//        if (volume.equalsIgnoreCase("UP")) {
//            getBinding().volumeSeek.seekBar2.setProgress((getBinding().volumeSeek.seekBar2.getProgress() + 1 > getBinding().volumeSeek.seekBar2.getMax()) ? getBinding().volumeSeek.seekBar2.getMax() : getBinding().volumeSeek.seekBar2.getProgress() + 1);
//        } else {
//            getBinding().volumeSeek.seekBar2.setProgress((getBinding().volumeSeek.seekBar2.getProgress() - 1 < 0) ? 0 : getBinding().volumeSeek.seekBar2.getProgress() - 1);
//        }
//
//    }
//
//    public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {
//
//        private String url;
//        private ImageView imageView;
//
//        public ImageLoadTask(String url, ImageView imageView) {
//            this.url = url;
//            this.imageView = imageView;
//        }
//
//        @Override
//        protected Bitmap doInBackground(Void... params) {
//            try {
//                URL urlConnection = new URL(url);
//                HttpURLConnection connection = (HttpURLConnection) urlConnection
//                        .openConnection();
//                connection.setDoInput(true);
//                connection.connect();
//                InputStream input = connection.getInputStream();
//
//                myBitmap = BitmapFactory.decodeStream(input);
//                // spritesHashMap = framesFromImageStream(input,100);
//                return myBitmap;
//            } catch (Exception e) {
//                Log.d("gtgtgtgtgtgtgt", e.getMessage());
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap result) {
//            super.onPostExecute(result);
//            // getBinding().imagePreview.setVisibility(View.VISIBLE);
//            // imageView.setImageBitmap(result);
//            try {
//                if (result != null) {
//                    InputStream inputStream = convertBitmaptoInputStream(result);
//                    spritesHashMap = framesFromImageStream(inputStream, 100);
//                }
//            } catch (IOException e) {
//                Log.d("gtgtgtgtgtgtgt", e.getMessage());
//            }
//
//
//        }
//
//    }
//
//    private InputStream convertBitmaptoInputStream(Bitmap bitmap) {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100 /*ignored for PNG*/, bos);
//        byte[] bitmapdata = bos.toByteArray();
//        ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);
//        return bs;
//    }
//
//    private HashMap<String, Bitmap> framesFromImageStream(InputStream inputStream, int columns) throws IOException {
//        Log.d("gtgtgtgtgtgtgt", "Enter");
//        previewImagesHashMap = new HashMap<String, Bitmap>();
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.RGB_565;
//        BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, false);
//        int previewImageIndex = 0;
//
////        previewImageWidth ?: 150, previewImageHeight ?: 84, slicesCount ?: 100,
//
//        for (int var7 = columns; previewImageIndex < var7; ++previewImageIndex) {
//            Rect cropRect = new Rect((previewImageIndex * 150), 0, (previewImageIndex * 150 + 150), 84);
//
//            Bitmap extractedImageBitmap;
//            try {
//                extractedImageBitmap = bitmapRegionDecoder.decodeRegion(cropRect, options);
//            } catch (IllegalArgumentException exc) {
//                Log.d("abcccc", "http://cdnapi.kaltura.com/p/2433871/sp/243387100/thumbnail/entry_id/0_o9m122mv/width/150/vid_slices/84");
//                if (previewImagesHashMap != null) {
//                    previewImagesHashMap.clear();
//                }
//
//                bitmapRegionDecoder.recycle();
//                return null;
//            }
//            //getBinding().imagePreview.setImageBitmap(extractedImageBitmap);
//            previewImagesHashMap.put(String.valueOf(previewImageIndex), extractedImageBitmap);
//            Log.d("frfrfrfrfrf", previewImageIndex + extractedImageBitmap.toString());
//        }
//
//        bitmapRegionDecoder.recycle();
//        return previewImagesHashMap;
//    }
//
//
}