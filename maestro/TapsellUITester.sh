start_time=$(date +%s)

echo "Take a coffee until my tests are done! ☕️☕️☕️"
echo "Starting Automated Smock UI Testing ..."

rm -rf maestro-outputs

maestro test rewarded.yaml
maestro test interstitial.yaml
maestro test native.yaml
maestro test native-video.yaml
maestro test native-multiple.yaml
maestro test standard.yaml
maestro test preroll.yaml

mv *.mp4 maestro-outputs

end_time=$(date +%s)

time_elapsed=$((end_time - start_time))
echo "Time elapsed: $((time_elapsed / 60)) minutes and $((time_elapsed % 60)) seconds."
