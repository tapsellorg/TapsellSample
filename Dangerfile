message "Please fill the PR description. \n" +
        "Read more about Conventional commit messages [here](https://www.conventionalcommits.org/en/v1.0.0/)"

# Throw an error if PR label is missing
failure "Please add labels to this PR" if github.pr_labels.empty?

# Throw an error if PR summary is missing
failure "Please provide a summary in the Pull Request description" if github.pr_body.length < 5

# Throw an error if PR assignee is missing
warn "This PR does not have any assignees yet." unless github.pr_json["assignee"]

# Highlight with a clickable link if a `libs.versions.toml` is changed
warn "#{github.html_link("libs.versions.toml")} was edited." if git.modified_files.include? "libs.versions.toml"

