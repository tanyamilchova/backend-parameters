## helm upgrade

upgrade a release

### Synopsis


This command upgrades a release to a new version of a chart.

The upgrade arguments must be a release and chart. The chart
argument can be either: a chart reference('example/mariadb'), a path to a chart directory,
a packaged chart, or a fully qualified URL. For chart references, the latest
version will be specified unless the '--version' flag is set.

To override values in a chart, use either the '--values' flag and pass in a file
or use the '--set' flag and pass configuration from the command line, to force string
values, use '--set-string'. You can use '--set-file' to set individual
values from a file when the value itself is too long for the command line
or is dynamically generated. You can also use '--set-json' to set json values
(scalars/objects/arrays) from the command line.

You can specify the '--values'/'-f' flag multiple times. The priority will be given to the
last (right-most) file specified. For example, if both myvalues.yaml and override.yaml
contained a key called 'Test', the value set in override.yaml would take precedence:

    $ helm upgrade -f myvalues.yaml -f override.yaml redis ./redis

You can specify the '--set' flag multiple times. The priority will be given to the
last (right-most) set specified. For example, if both 'bar' and 'newbar' values are
set for a key called 'foo', the 'newbar' value would take precedence:

    $ helm upgrade --set foo=bar --set foo=newbar redis ./redis

You can update the values for an existing release with this command as well via the
'--reuse-values' flag. The 'RELEASE' and 'CHART' arguments should be set to the original
parameters, and existing values will be merged with any values set via '--values'/'-f'
or '--set' flags. Priority is given to new values.

    $ helm upgrade --reuse-values --set foo=bar --set foo=newbar redis ./redis

The --dry-run flag will output all generated chart manifests, including Secrets
which can contain sensitive values. To hide Kubernetes Secrets use the
--hide-secret flag. Please carefully consider how and when these flags are used.


```
helm upgrade [RELEASE] [CHART] [flags]
```

### Options

```
      --atomic                                     if set, upgrade process rolls back changes made in case of failed upgrade. The --wait flag will be set automatically if --atomic is used
      --ca-file string                             verify certificates of HTTPS-enabled servers using this CA bundle
      --cert-file string                           identify HTTPS client using this SSL certificate file
      --cleanup-on-fail                            allow deletion of new resources created in this upgrade when upgrade fails
      --create-namespace                           if --install is set, create the release namespace if not present
      --dependency-update                          update dependencies if they are missing before installing the chart
      --description string                         add a custom description
      --devel                                      use development versions, too. Equivalent to version '>0.0.0-0'. If --version is set, this is ignored
      --disable-openapi-validation                 if set, the upgrade process will not validate rendered templates against the Kubernetes OpenAPI Schema
      --dry-run string[="client"]                  simulate an install. If --dry-run is set with no option being specified or as '--dry-run=client', it will not attempt cluster connections. Setting '--dry-run=server' allows attempting cluster connections.
      --enable-dns                                 enable DNS lookups when rendering templates
      --force                                      force resource updates through a replacement strategy
  -h, --help                                       help for upgrade
      --hide-notes                                 if set, do not show notes in upgrade output. Does not affect presence in chart metadata
      --hide-secret                                hide Kubernetes Secrets when also using the --dry-run flag
      --history-max int                            limit the maximum number of revisions saved per release. Use 0 for no limit (default 10)
      --insecure-skip-tls-verify                   skip tls certificate checks for the chart download
  -i, --install                                    if a release by this name doesn't already exist, run an install
      --key-file string                            identify HTTPS client using this SSL key file
      --keyring string                             location of public keys used for verification (default "C:\\Users\\YelzhanRakhimzhanov\\.gnupg\\pubring.gpg")
  -l, --labels stringToString                      Labels that would be added to release metadata. Should be separated by comma. Original release labels will be merged with upgrade labels. You can unset label using null. (default [])
      --no-hooks                                   disable pre/post upgrade hooks
  -o, --output format                              prints the output in the specified format. Allowed values: table, json, yaml (default table)
      --pass-credentials                           pass credentials to all domains
      --password string                            chart repository password where to locate the requested chart
      --plain-http                                 use insecure HTTP connections for the chart download
      --post-renderer postRendererString           the path to an executable to be used for post rendering. If it exists in $PATH, the binary will be used, otherwise it will try to look for the executable at the given path
      --post-renderer-args postRendererArgsSlice   an argument to the post-renderer (can specify multiple) (default [])
      --render-subchart-notes                      if set, render subchart notes along with the parent
      --repo string                                chart repository url where to locate the requested chart
      --reset-then-reuse-values                    when upgrading, reset the values to the ones built into the chart, apply the last release's values and merge in any overrides from the command line via --set and -f. If '--reset-values' or '--reuse-values' is specified, this is ignored
      --reset-values                               when upgrading, reset the values to the ones built into the chart
      --reuse-values                               when upgrading, reuse the last release's values and merge in any overrides from the command line via --set and -f. If '--reset-values' is specified, this is ignored
      --set stringArray                            set values on the command line (can specify multiple or separate values with commas: key1=val1,key2=val2)
      --set-file stringArray                       set values from respective files specified via the command line (can specify multiple or separate values with commas: key1=path1,key2=path2)
      --set-json stringArray                       set JSON values on the command line (can specify multiple or separate values with commas: key1=jsonval1,key2=jsonval2)
      --set-literal stringArray                    set a literal STRING value on the command line
      --set-string stringArray                     set STRING values on the command line (can specify multiple or separate values with commas: key1=val1,key2=val2)
      --skip-crds                                  if set, no CRDs will be installed when an upgrade is performed with install flag enabled. By default, CRDs are installed if not already present, when an upgrade is performed with install flag enabled
      --skip-schema-validation                     if set, disables JSON schema validation
      --take-ownership                             if set, upgrade will ignore the check for helm annotations and take ownership of the existing resources
      --timeout duration                           time to wait for any individual Kubernetes operation (like Jobs for hooks) (default 5m0s)
      --username string                            chart repository username where to locate the requested chart
  -f, --values strings                             specify values in a YAML file or a URL (can specify multiple)
      --verify                                     verify the package before using it
      --version string                             specify a version constraint for the chart version to use. This constraint can be a specific tag (e.g. 1.1.1) or it may reference a valid range (e.g. ^2.0.0). If this is not specified, the latest version is used
      --wait                                       if set, will wait until all Pods, PVCs, Services, and minimum number of Pods of a Deployment, StatefulSet, or ReplicaSet are in a ready state before marking the release as successful. It will wait for as long as --timeout
      --wait-for-jobs                              if set and --wait enabled, will wait until all Jobs have been completed before marking the release as successful. It will wait for as long as --timeout
```

### Options inherited from parent commands

```
      --burst-limit int                 client-side default throttling limit (default 100)
      --debug                           enable verbose output
      --kube-apiserver string           the address and the port for the Kubernetes API server
      --kube-as-group stringArray       group to impersonate for the operation, this flag can be repeated to specify multiple groups.
      --kube-as-user string             username to impersonate for the operation
      --kube-ca-file string             the certificate authority file for the Kubernetes API server connection
      --kube-context string             name of the kubeconfig context to use
      --kube-insecure-skip-tls-verify   if true, the Kubernetes API server's certificate will not be checked for validity. This will make your HTTPS connections insecure
      --kube-tls-server-name string     server name to use for Kubernetes API server certificate validation. If it is not provided, the hostname used to contact the server is used
      --kube-token string               bearer token used for authentication
      --kubeconfig string               path to the kubeconfig file
  -n, --namespace string                namespace scope for this request
      --qps float32                     queries per second used when communicating with the Kubernetes API, not including bursting
      --registry-config string          path to the registry config file (default "C:\\Users\\YelzhanRakhimzhanov\\AppData\\Roaming\\helm\\registry\\config.json")
      --repository-cache string         path to the directory containing cached repository indexes (default "C:\\Users\\YELZHA~1\\AppData\\Local\\Temp\\helm\\repository")
      --repository-config string        path to the file containing repository names and URLs (default "C:\\Users\\YelzhanRakhimzhanov\\AppData\\Roaming\\helm\\repositories.yaml")
```

### SEE ALSO

* [helm](helm.md)	 - The Helm package manager for Kubernetes.

###### Auto generated by spf13/cobra on 18-Jul-2025
